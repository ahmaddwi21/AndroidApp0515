package com.example.amikom.screennav;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout myTab;
    ViewPager myPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTab =(TabLayout)findViewById(R.id.myTab);
        myPage = (ViewPager)findViewById(R.id.view2);

        myPage.setAdapter(new MyOwnPagerAdapter(getSupportFragmentManager()));
        myTab.setupWithViewPager(myPage);

        myTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myTab.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                myPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    class MyOwnPagerAdapter extends FragmentPagerAdapter{

        String data[]= {"Java","Android","IOS"};

        public MyOwnPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new Java();
            }
            if(position == 1){
                return new Android();
            }
            if(position == 2){
                return new IOS();
            }
            return null;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }
}
