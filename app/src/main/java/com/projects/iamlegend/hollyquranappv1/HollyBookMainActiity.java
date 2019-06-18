package com.projects.iamlegend.hollyquranappv1;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranapp1.models.Constants;
import com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranappv1.adapters.ChaptersAdapter;

public class HollyBookMainActiity extends Fragment {

    RecyclerView ChaptersRV;
    ChaptersAdapter chaptersAdapter;
    RecyclerView.LayoutManager layoutmgr;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_holly_book_main_actiity);
        view= inflater.inflate(R.layout.activity_holly_book_main_actiity, container, false);
        ChaptersRV = view.findViewById(R.id.chapterRV);
        chaptersAdapter = new ChaptersAdapter(Constants.ArSuras);
        layoutmgr = new GridLayoutManager(getActivity(),3, LinearLayoutManager.HORIZONTAL,false);
        ChaptersRV.setAdapter(chaptersAdapter);
        ChaptersRV.setLayoutManager(layoutmgr);

        chaptersAdapter.setOnItemClickListener(
                new ChaptersAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int pos, String chapterName,Context context) {
                        Intent intent = new Intent(getActivity(),chapter_item_display.class);
                        intent.putExtra("chapterNo",pos);
                         intent.putExtra("chapterName",chapterName);
                        startActivity(intent);
                        /*((HollyBookMainActiity)context).finish();*/
                    }
                }
        );
        return view;
    }
}
