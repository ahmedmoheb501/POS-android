package com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranapp1.models;

/**
 * Created by IAMLEGEND on 6/17/2019.
 */

public class Chapter {

    public int chapterIndex;
    public String chapterName;
    public int versesCount;
    public int chapterLocation;

    public Chapter(int chapterIndex, String chapterName, int versesCount, int chapterLocation) {
        this.chapterIndex = chapterIndex;
        this.chapterName = chapterName;
        this.versesCount = versesCount;
        this.chapterLocation = chapterLocation;
    }
}
