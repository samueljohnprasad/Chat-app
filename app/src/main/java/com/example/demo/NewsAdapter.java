package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>  {

    Context mContext;
    List<NewsItem> mData;



    public NewsAdapter(Context mContext, List<NewsItem> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }



    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout= LayoutInflater.from(mContext).inflate(R.layout.item_news,viewGroup,false);

        return new NewsViewHolder(layout);
    }





    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {


        newsViewHolder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_animation));
        //newsViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_text));
        //newsViewHolder.tv_title.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_text));




        newsViewHolder.tv_title.setText(mData.get(position).getTitle());
        newsViewHolder.tv_content.setText(mData.get(position).getContent());
        newsViewHolder.tv_data.setText(mData.get(position).getData());

         newsViewHolder.img_user.setImageResource(mData.get(position).getUserPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class  NewsViewHolder extends  RecyclerView.ViewHolder {



        TextView tv_title,tv_content,tv_data;
        ImageView img_user;
        RelativeLayout container;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title=itemView.findViewById(R.id.tv_title);
            tv_content=itemView.findViewById(R.id.tv_description);
            tv_data=itemView.findViewById(R.id.tv_data);

            img_user=itemView.findViewById(R.id.img_user);
            container=itemView.findViewById(R.id.recycler);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    recyclerViewClickInterface.onItemClick(getAdapterPosition());
//                }
//            });
//
//
//
//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//
//                    mData.remove(getAdapterPosition());
//                    notifyItemRemoved(getAdapterPosition());
//                    recyclerViewClickInterface.onLongItemClick(getAdapterPosition());
//                    return true;
//                }
//            });

//            if(isDark){
//                setDarkTheme();
//
//            }
//
            //newViewHolder
        }

//        @Override
//        public void onClick(View v) {
//
//            String lol= mData.get(getAdapterPosition()).getTitle();
//
//            Toast.makeText(v.getContext(), "i " + lol, Toast.LENGTH_SHORT).show();
//        }



//        private void setDarkTheme()
//        {
//            container.setBackgroundResource(R.drawable.card_bg_dark);
//        }


    }

}
