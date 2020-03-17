package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import static com.example.demo.R.color.yellow;


public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ViewPageAdapter viewPageAdapter;  //class as object


    private Toolbar toolbar;

    int k;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main); // this be after FLSG_FULLSCREEEN


        // getSupportActionBar().hide();

        //getSupportActionBar().hide();


//        mData.add(new NewsItem("samueljohnprasad","its raining","14 june 2020",R.drawable.contact1));
//        mData.add(new NewsItem("sam","im busy right now","14 june 2020",R.drawable.contact2));
//        mData.add(new NewsItem("john","hey how are you doing","15 june 2020",R.drawable.contact3));
//        mData.add(new NewsItem("johny","where do you live","16 june 2020",R.drawable.contact4));


        //tabsBar_layout

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());


        viewPageAdapter.AddFragment(new fragmentCall(), "Tweet");       //add fragment to adaptor...addind titles nd initilizing fragments
        viewPageAdapter.AddFragment(new fragmentContact(), "Chat");
        viewPageAdapter.AddFragment(new fragmentFav(), "Story");   //calling viewpageadapter class method
        //adapter is name of viewpageadater

        viewPager.setAdapter(viewPageAdapter);                            //add adapter(viewpageAdater) to viewpager
        tabLayout.setupWithViewPager(viewPager);                  //add viewpager to tablayout


        tabLayout.getTabAt(0);     //tab icons
        tabLayout.getTabAt(1);
        tabLayout.getTabAt(2);

        tabLayout.getSelectedTabPosition();


//.setIcon(R.drawable.ic_add_a_photo_black_24dp)
        tabLayout.getTabAt(1).select();


//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setElevation(0);                      //remove shadow from action bar


    }


}
