package com.liuhui.xlceremony.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.liuhui.xlceremony.app.ui.fragment.FindFragmentKaquan;
import com.liuhui.xlceremony.app.ui.fragment.FindFragmentKaquan2;

/**
 * Created by Administrator on 2015/8/21.
 */
public class FindPagerAdapter extends FragmentStatePagerAdapter {

    int number;

    public FindPagerAdapter(FragmentManager fm, int number) {
        super(fm);
        this.number=number;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                FindFragmentKaquan tab1 = new FindFragmentKaquan();
                return tab1;
            case 1:
                FindFragmentKaquan2 tab2 = new FindFragmentKaquan2();
                return tab2;
        }

        return null;
    }

    @Override
    public int getCount() {
        return number;
    }
}
