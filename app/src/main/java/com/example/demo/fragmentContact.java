package com.example.demo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fragmentContact extends Fragment {


    private RecyclerView recyclerView;

    private List<NewsItem> mData;        //Contact is class
    NewsAdapter newsAdapter;



    public fragmentContact() {
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v=inflater.inflate(R.layout.contacts_fragment,container,false);


        recyclerView=(RecyclerView) v.findViewById(R.id.news_rv);
        newsAdapter=new NewsAdapter(getContext(),mData);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        ItemTouchHelper itemTouchHelper= new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);



        return v;

        //onCreateView
    }

    List<NewsItem> archived = new ArrayList<>();
ItemTouchHelper.SimpleCallback simpleCallback= new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN|ItemTouchHelper.START|ItemTouchHelper.END,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {


        int fromPosition =viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();

        Collections.swap(mData,fromPosition,toPosition);

        recyclerView.getAdapter().notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        final int position= viewHolder.getAdapterPosition();
        final NewsItem deletedChat  = mData.get(position);
        final String namee  = mData.get(position).getTitle();



        switch (direction){

            case ItemTouchHelper.LEFT:

                mData.remove(position);
                newsAdapter.notifyItemRemoved(position);

                Snackbar.make(recyclerView,namee+" deleted",Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                mData.add(position,deletedChat);
                                newsAdapter.notifyItemInserted(position);


                            }
                        }).show();

                break;

            case ItemTouchHelper.RIGHT:

                final NewsItem movieName=mData.get(position);
                final String name=mData.get(position).getTitle();

                archived.add(movieName);

                mData.remove(position);
                newsAdapter.notifyItemRemoved(position);

                Snackbar.make(recyclerView,name + " Archive", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                archived.remove(archived.lastIndexOf(movieName));
                                mData.add(position,movieName);

                                newsAdapter.notifyItemInserted(position);


                            }
                        }).show();


                break;

        }



    }
};



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


         mData=new ArrayList<>();
        mData.add(new NewsItem("samueljohnprasad","im using a very slow laptop","14 june 2020",R.drawable.contact1));
        mData.add(new NewsItem("sam","hey how are you doing","14 june 2020",R.drawable.contact2));
        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
        mData.add(new NewsItem("johny","recyclerview not functioning","16 june 2020",R.drawable.contact4));


        mData.add(new NewsItem("samueljohnprasad","im using a very slow laptop","14 june 2020",R.drawable.contact1));
        mData.add(new NewsItem("sam","hey how are you doing","14 june 2020",R.drawable.contact2));
        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
        mData.add(new NewsItem("johny","recyclerview not functioning","16 june 2020",R.drawable.contact4));


        mData.add(new NewsItem("samueljohnprasad","im using a very slow laptop","14 june 2020",R.drawable.contact1));
        mData.add(new NewsItem("sam","hey how are you doing","14 june 2020",R.drawable.contact2));
        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
        mData.add(new NewsItem("johny","recyclerview not functioning","16 june 2020",R.drawable.contact4));


        mData.add(new NewsItem("samueljohnprasad","im using a very slow laptop","14 june 2020",R.drawable.contact1));
        mData.add(new NewsItem("sam","hey how are you doing","14 june 2020",R.drawable.contact2));
        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
        mData.add(new NewsItem("johny","recyclerview not functioning","16 june 2020",R.drawable.contact4));



        mData.add(new NewsItem("samueljohnprasad","im using a very slow laptop","14 june 2020",R.drawable.contact1));
        mData.add(new NewsItem("sam","hey how are you doing","14 june 2020",R.drawable.contact2));
        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
        mData.add(new NewsItem("johny","recyclerview not functioning","16 june 2020",R.drawable.contact4));


        mData.add(new NewsItem("samueljohnprasad","im using a very slow laptop","14 june 2020",R.drawable.contact1));
        mData.add(new NewsItem("sam","hey how are you doing","14 june 2020",R.drawable.contact2));
        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
        mData.add(new NewsItem("johny","recyclerview not functioning","16 june 2020",R.drawable.contact4));


        mData.add(new NewsItem("samueljohnprasad","im using a very slow laptop","14 june 2020",R.drawable.contact1));
        mData.add(new NewsItem("sam","hey how are you doing","14 june 2020",R.drawable.contact2));
        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
        mData.add(new NewsItem("johny","recyclerview not functioning","16 june 2020",R.drawable.contact4));


        mData.add(new NewsItem("samueljohnprasad","im using a very slow laptop","14 june 2020",R.drawable.contact1));
        mData.add(new NewsItem("sam","hey how are you doing","14 june 2020",R.drawable.contact2));
        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
        mData.add(new NewsItem("johny","recyclerview not functioning","16 june 2020",R.drawable.contact4));


        mData.add(new NewsItem("samueljohnprasad","im using a very slow laptop","14 june 2020",R.drawable.contact1));
        mData.add(new NewsItem("sam","hey how are you doing","14 june 2020",R.drawable.contact2));
        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
        mData.add(new NewsItem("johny","recyclerview not functioning","16 june 2020",R.drawable.contact4));




    }
}
