package com.projects.iamlegend.hollyquranappv1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranapp1.models.HadethShareef;
import com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranappv1.adapters.hadethAdapter;

import java.util.ArrayList;

public class ahadeth_activity extends Fragment {

    ArrayList<HadethShareef> hadethData;
    RecyclerView hadeth_RV;
    RecyclerView.LayoutManager laymgr;
    hadethAdapter hadethAdapter;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_ahadeth_activity);
        view = inflater.inflate(R.layout.activity_ahadeth_activity, container, false);
        //Initializations
        hadeth_RV = view.findViewById(R.id.ahadeth_RV);
        hadethData = HadethShareef.parseDataSource("hadeth.txt",getActivity().getApplicationContext());
        laymgr = new GridLayoutManager(getActivity(),3, 1,false);
        hadethAdapter = new hadethAdapter(hadethData);

        //Render RV
        hadeth_RV.setAdapter(hadethAdapter);
        hadeth_RV.setLayoutManager(laymgr);

        hadethAdapter.setOnItemClickListener(new hadethAdapter.OnItemClickListener() {
            @Override
            public void onClickItem(int position) {
                /*Fragment HadeethFragment = new hadeeth_fragment();
                ((hadeeth_fragment)HadeethFragment).setSpeech(hadethData.get(position).getSpeech());
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_cointainer,HadeethFragment)
                        .addToBackStack("")
                        .commit();*/

                //Dialog Fragment
                FragmentManager fm = getActivity().getSupportFragmentManager();
                hadethDialogFragment fragment = hadethDialogFragment.newInstance(hadethData.get(position).getSpeech());
                fragment.show(fm, "hadeeth_fragment");

            }
        });
        return view;
    }
}
