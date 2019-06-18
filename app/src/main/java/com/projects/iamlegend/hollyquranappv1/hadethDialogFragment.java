package com.projects.iamlegend.hollyquranappv1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by IAMLEGEND on 6/13/2019.
 */

public class hadethDialogFragment extends DialogFragment {

    private TextView hadethSpeechTV;

    public hadethDialogFragment()
    {}

    public static hadethDialogFragment newInstance(String speech)
    {
        hadethDialogFragment hadethFragment = new hadethDialogFragment();

        Bundle args = new Bundle();
        args.putString("speech",speech);
        hadethFragment.setArguments(args);
        return hadethFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hadeeth_fragment, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get field from view
        hadethSpeechTV = (TextView) view.findViewById(R.id.speech_TV);
        // Fetch arguments from bundle and set title
        String speech = getArguments().getString("speech", "Loading prophet speech...");
        getDialog().setTitle("Prophet Speech");
        // Show soft keyboard automatically and request focus to field
        //mEditText.requestFocus();
        /*getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);*/
    }


}
