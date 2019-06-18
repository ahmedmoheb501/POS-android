package com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranappv1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.iamlegend.hollyquranappv1.R;
import com.projects.iamlegend.hollyquranappv1.com.projects.iamlegend.hollyquranapp1.models.HadethShareef;

import java.util.ArrayList;

/**
 * Created by IAMLEGEND on 5/8/2019.
 */

public class hadethAdapter extends RecyclerView.Adapter<hadethAdapter.ViewHolder>{

    ArrayList<HadethShareef> hadethData = new ArrayList<HadethShareef>();

    public hadethAdapter(ArrayList<HadethShareef> hadethData)
    {
        this.hadethData = hadethData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.hadeth_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        HadethShareef hadeth = hadethData.get(position);
        viewHolder.hadeth_TV.setText(hadeth.getTitle());
        if(onItemClickListener!=null)
        {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(){

                                                       @Override
                                                       public void onClick(View v) {
                                                           onItemClickListener.onClickItem(position);
                                                       }
                                                   }

            );
        }

    }


    @Override
    public int getItemCount() {
        return (hadethData == null) ? 0 : hadethData.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }

    OnItemClickListener onItemClickListener;
    public interface OnItemClickListener
    {
        void onClickItem(int position);
    }


    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView hadeth_TV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hadeth_TV = (TextView) itemView.findViewById(R.id.hadeth_name_TV);
        }
    }

}
