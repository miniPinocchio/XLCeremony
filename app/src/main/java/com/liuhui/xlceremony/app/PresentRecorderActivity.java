package com.liuhui.xlceremony.app;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhui.xlceremony.app.adapter.FragmentStateAdapter;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.util.BlankAFragment;
import com.liuhui.xlceremony.app.util.BlankBFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class PresentRecorderActivity extends BaseActivity implements View.OnClickListener, 
		TabLayout.OnTabSelectedListener {
	@InjectView(R.id.actionBarTitle)
	TextView title;
	@InjectView(R.id.back)
	ImageView imageView;
	@InjectView(R.id.present_record_tab_bar)
	TabLayout tabLayout;
	@InjectView(R.id.present_record_pager)
	ViewPager viewPager;
	@Override
	protected void initViews() {
		setContentView(R.layout.activity_present_recorder);
		ButterKnife.inject(this);
		title.setText(R.string.present_recorder_title);
		imageView.setOnClickListener(this);

		TabLayout.Tab tab = tabLayout.newTab();
		tab.setText("收到");
		tabLayout.addTab(tab);
		TabLayout.Tab tab1 = tabLayout.newTab();
		tab1.setText("发出");
		tabLayout.addTab(tab1);
		
		tabLayout.setOnTabSelectedListener(this);
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
				(tabLayout));
		
		List<Fragment> list = new ArrayList<Fragment>();
		list.add(new BlankAFragment());
		list.add(new BlankBFragment());

		viewPager.setAdapter(new FragmentStateAdapter(getSupportFragmentManager(), list));
	}

	@Override
	public void onClick(View v) {
		finish();
	}
	

	@Override
	public void onTabSelected(TabLayout.Tab tab) {

		int position = tab.getPosition();
		viewPager.setCurrentItem(position);
	}

	@Override
	public void onTabUnselected(TabLayout.Tab tab) {

	}

	@Override
	public void onTabReselected(TabLayout.Tab tab) {
		
	}
}
