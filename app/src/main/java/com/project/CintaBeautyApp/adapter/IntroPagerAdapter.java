package com.project.CintaBeautyApp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.project.CintaBeautyApp.ui.intro.FirstFragment;
import com.project.CintaBeautyApp.ui.intro.SecondFragment;
import com.project.CintaBeautyApp.ui.intro.ThirdFragment;

public class IntroPagerAdapter extends FragmentPagerAdapter {

    public IntroPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FirstFragment.newInstance();
            case 1:
                return SecondFragment.newInstance();
            case 2:
                return ThirdFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
