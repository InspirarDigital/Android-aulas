package com.atilabraga.aula2.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.atilabraga.aula2.R;
import com.atilabraga.aula2.ui.PagesFragment;

/**
 * Created by atilabraga on 9/26/15.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PagesFragment.getInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.lbl_login);

            case 1:
                return mContext.getString(R.string.lbl_register);
        }
        return "";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
