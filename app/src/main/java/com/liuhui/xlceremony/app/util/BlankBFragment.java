package com.liuhui.xlceremony.app.util;


import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankBFragment extends BaseFragment {
	

	@Override
	public View initView(LayoutInflater inflater, ViewGroup container) {
		return inflater.inflate(R.layout.fragment_blank_b, container, false);
	}

	@Override
	public void initData() {
		
	}


}
