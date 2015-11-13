package com.atilabraga.material;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by atilabraga on 10/31/15.
 */
public class MaterialPagerAdapter extends FragmentStatePagerAdapter {

    public MaterialPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MaterialFragment.newInstance(String.valueOf(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab #" + position;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
