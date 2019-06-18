package com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranapp1.models;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by IAMLEGEND on 5/8/2019.
 */

public class HadethShareef {

    //props
    String title;
    String speech;
    int index;

    //Getter and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    //constructor
    public HadethShareef()
    {

    }
    public HadethShareef(String title,String speech)
    {
       this.title = title;
       this.speech = speech;
    }

    //Logic
    public static ArrayList<HadethShareef> parseDataSource(String fileName, Context context)
    {
        ArrayList<HadethShareef> HadethDataSource = new ArrayList<HadethShareef>();
        BufferedReader reader;

        try{
            InputStream file = context.getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            int hadethIndex=0;
            HadethShareef newHadeth;
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                newHadeth = new HadethShareef();
                //line = reader.readLine();
                newHadeth.title = line;
                newHadeth.speech = "";
                do{
                    line = reader.readLine();
                    newHadeth.speech +=line;
                }while(!line.contains("#"));
                //line +=" ("+verseIndex+") ";
                newHadeth.index =  hadethIndex++;
                newHadeth.speech = newHadeth.speech.replace("#","");
                HadethDataSource.add(newHadeth);
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return HadethDataSource;
    }
}
