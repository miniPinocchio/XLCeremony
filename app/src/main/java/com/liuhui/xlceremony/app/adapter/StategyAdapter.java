package com.liuhui.xlceremony.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Ziv on Android Studio
 * com.liuhui.xlceremony.app.adapter
 * 2015/8/20.
 */

/**
 * 情礼攻略左右滑动加载Fragment的数据适配器
 */
public class StategyAdapter extends FragmentStatePagerAdapter{
    public StategyAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 0;
    }
}
