package com.project.CintaBeautyApp.ui.intro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.project.CintaBeautyApp.R;
import com.project.CintaBeautyApp.adapter.IntroPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        DotsIndicator dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator);

        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        IntroPagerAdapter adapterViewPager = new IntroPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapterViewPager);
        dotsIndicator.attachTo(pager);
    }
}