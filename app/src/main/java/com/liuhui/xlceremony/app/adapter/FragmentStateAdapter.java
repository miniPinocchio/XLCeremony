package com.liuhui.xlceremony.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created from "com.liuhui.xlceremony.app.adapter".
 * User ：${Yan}[ZY] on 2015/8/24 0024 17:25
 * Email ：530412159@qq.com
 */
public class FragmentStateAdapter extends FragmentStatePagerAdapter {
	List<Fragment> fragmentLists;
	public FragmentStateAdapter(FragmentManager fm,List<Fragment> fragmentLists) {
		super(fm);
		this.fragmentLists =fragmentLists;
	}
	@Override
	public int getCount() {
		int ret =0;
		if (fragmentLists != null) {
			ret =fragmentLists.size();
		}
		return ret;
	}

	@Override
	public Fragment getItem(int position) {
		return fragmentLists.get(position);
	}
}
