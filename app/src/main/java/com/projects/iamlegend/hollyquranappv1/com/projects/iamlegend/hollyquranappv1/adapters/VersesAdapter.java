package com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranappv1.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.iamlegend.hollyquranappv1.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by IAMLEGEND on 4/28/2019.
 */

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.ViewHolder> {

    ArrayList<String> verses;
    public VersesAdapter(ArrayList<String> verses){

        this.verses = verses;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.verses_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.verseTV.setText(verses.get(position));
    }

    @Override
    public int getItemCount() {
        return verses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView verseTV;
        public ViewHolder(View view) {
            super(view);
            verseTV = view.findViewById(R.id.verseTV);
        }
    }
}
