package com.example.musicapp.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.musicapp.Adapter.MainViewPaperAdapter;
import com.example.musicapp.Fragment.Fragment_Tim_Kiem;
import com.example.musicapp.Fragment.Fragment_Trang_Chu;
import com.example.musicapp.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private void init() {
        MainViewPaperAdapter mainViewPaperAdapter = new MainViewPaperAdapter(getSupportFragmentManager());
        mainViewPaperAdapter.addFragment(new Fragment_Trang_Chu(), "Trang chu");
        mainViewPaperAdapter.addFragment(new Fragment_Tim_Kiem(), "Tim Kiem");
        viewPager.setAdapter(mainViewPaperAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontimkiem);
    }

    private void anhxa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPaper);
    }
}
