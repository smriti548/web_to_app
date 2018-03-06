package com.smriti.viewpager;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
ViewPager vpager;
    MyPageAdapter myPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpager=(ViewPager)findViewById(R.id.vpager);
        myPageAdapter= new MyPageAdapter(getSupportFragmentManager());
        vpager.setAdapter(myPageAdapter);
        vpager.setCurrentItem(1);
    }
    public static class MyPageAdapter extends FragmentPagerAdapter{
        public static int NUM =3;
        public MyPageAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new firstfragment();
                case 1:
                    return new secondfragment();
                case 2:
                    return new thirdfragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "CALLS";
                case 1:
                    return "chats";
                case 2:
                    return "contacts";
                default:
                    return null;
            }
        }
    }
}
