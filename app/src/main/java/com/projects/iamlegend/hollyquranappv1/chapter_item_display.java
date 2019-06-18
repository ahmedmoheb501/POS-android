package com.projects.iamlegend.hollyquranappv1;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranappv1.adapters.ChaptersAdapter;
import com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranappv1.adapters.VersesAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class chapter_item_display extends AppCompatActivity {

    RecyclerView versesRV;
    TextView chapterNameTV;
    VersesAdapter versesAdapter;
    RecyclerView.LayoutManager layoutmgr;


    String chapterName;
    int chapterNo;
    ArrayList<String> verses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_item_display);
        //Fetch Extras
        chapterName =getIntent().getExtras().get("chapterName").toString();
        chapterNo = Integer.parseInt(getIntent().getExtras().get("chapterNo").toString());
        //Get Controls
        versesRV = findViewById(R.id.versesRV);
        chapterNameTV = findViewById(R.id.chapterNameTV);
        //Fill Controls
        chapterNameTV.setText(chapterName);

        BufferedReader reader;
        verses = new ArrayList<String>();
        String fileName = (chapterNo+1)+".txt";
        try{
            InputStream file = this.getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = "";
            int verseIndex=1;
            do{
                line = reader.readLine();
                //line +=" ("+verseIndex+") ";
                verses.add(line);
                verseIndex++;
            }while(line!=null);
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

        //Recycle View
        versesAdapter = new VersesAdapter(verses);
        layoutmgr = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        versesRV.setAdapter(versesAdapter);
        versesRV.setLayoutManager(layoutmgr);

    }
}
