package com.projects.iamlegend.hollyquranappv1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class hadeeth_fragment extends Fragment {

    //Attributes
    public String speech;

    //setters and getters
    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    //Constructor
    public hadeeth_fragment()
    {

    }

    /*    public hadeeth_fragment(String speech) {
        // Required empty public constructor
        this.speech = speech;
    }*/
    TextView hadeethContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.hadeeth_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        hadeethContent = getView().findViewById(R.id.speech_TV);
        hadeethContent.setText(speech);
    }



}
