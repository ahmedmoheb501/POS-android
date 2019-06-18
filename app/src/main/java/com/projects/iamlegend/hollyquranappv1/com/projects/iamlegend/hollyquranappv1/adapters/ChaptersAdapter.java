package com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranappv1.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.iamlegend.hollyquranappv1.R;
import com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranapp1.models.Chapter;
import com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranapp1.models.Constants;


import java.util.ArrayList;



/**
 * Created by IAMLEGEND on 4/28/2019.
 */

public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersAdapter.ViewHolder> {

    String[] Chapters;
    ArrayList<Chapter> ChaptersList;
    public ChaptersAdapter(ArrayList<Chapter> ChaptersList)
    {
        this.ChaptersList = ChaptersList;
    }
    public ChaptersAdapter(String[] Chapters)
    {
        this.Chapters = Chapters;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemView) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chapter_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Chapter curChapter = ChaptersList.get(position);
        viewHolder.tv_chapterIndex.setText(curChapter.chapterIndex);
        viewHolder.tv_chapterName.setText(curChapter.chapterName);
        viewHolder.tv_versesCount.setText(curChapter.versesCount);
        int locationImage;
        if(String.valueOf(curChapter.chapterLocation) == Constants.chepterLocation.Makka.toString())
        {
            locationImage = viewHolder.Iv_chapterLocation.getContext().getResources()
                    .getIdentifier("makka", "drawable","com.projects.iamlegend.hollyquranappv1");
            //locationImage =  viewHolder.Iv_chapterLocation.getContext().getResources().getDrawable(R.drawable.makka);
                    //getIdentifier("com.projects.iamlegend.hollyquranappv1:drawable/" + "makka", null, null);
        }else
            locationImage = viewHolder.Iv_chapterLocation.getContext().getResources()
                    .getIdentifier("madina", "drawable","com.projects.iamlegend.hollyquranappv1");
            //locationImage =  viewHolder.Iv_chapterLocation.getContext().getDrawable(R.drawable.madina);
        viewHolder.Iv_chapterLocation.setImageResource(locationImage);
        //This is a test comment
        ///TODO  check for the listener
        if(OnItemClickListener!=null)
        {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(){

                   @Override
                   public void onClick(View v) {
                       OnItemClickListener.onItemClick(position,Chapters[position],v.getContext());
                   }
               }

            );
        }
    }

    @Override
    public int getItemCount() {
        return Chapters.length;
    }


    OnItemClickListener OnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClick)
    {
        this.OnItemClickListener = onItemClick;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos, String chapterName, Context context);
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_chapterName,tv_chapterIndex,tv_versesCount;
        ImageView Iv_chapterLocation;
        public ViewHolder(View view)
        {
            super(view);
            tv_chapterIndex = view.findViewById(R.id.ChapterIndex);
            tv_chapterName = view.findViewById(R.id.chapter_name);
            tv_versesCount = view.findViewById(R.id.versesCountTv);
            Iv_chapterLocation = view.findViewById(R.id.iv_maki_madani);
        }
    }
}
