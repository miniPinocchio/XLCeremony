package com.liuhui.xlceremony.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.liuhui.xlceremony.app.ui.fragment.FindCareFragment1;

/**
 * Created by Administrator on 2015/8/21.
 */
public class CarePagerAdapter extends FragmentStatePagerAdapter {

    int number;

    public CarePagerAdapter(FragmentManager fm, int number) {
        super(fm);
        this.number=number;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                FindCareFragment1 tab1 = new FindCareFragment1();
                return tab1;
            case 1:
               // FindFragmentKaquan2 tab2 = new FindFragmentKaquan2();
               // return tab2;
                FindCareFragment1 tab2 = new FindCareFragment1();
                return tab2;
        }

        return null;
    }

    @Override
    public int getCount() {
        return number;
    }
}
