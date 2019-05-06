package com.example.musicapp.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPaperAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayFragement = new ArrayList<>();
    private ArrayList<String> arraytitle = new ArrayList<>();


    public MainViewPaperAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return arrayFragement.get(i);
    }

    @Override
    public int getCount() {
        return arrayFragement.size();
    }

    public  void addFragment(Fragment fragment, String title){
        arrayFragement.add(fragment);
        arraytitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arraytitle.get(position);
    }
}
