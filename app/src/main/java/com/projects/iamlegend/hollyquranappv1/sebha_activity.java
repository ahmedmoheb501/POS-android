package com.projects.iamlegend.hollyquranappv1;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class sebha_activity extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sebha_activity);
        view= inflater.inflate(R.layout.activity_sebha_activity, container, false);
        return view;
    }

    public void tasbehClick(View view) {
        Toast.makeText(getActivity(),"",Toast.LENGTH_LONG).show();
    }

    public void onSpinnerArrowClick(View view) {
        Toast.makeText(getActivity(),"",Toast.LENGTH_LONG).show();
    }
}
