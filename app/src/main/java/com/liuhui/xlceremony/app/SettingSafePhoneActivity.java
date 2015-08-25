package com.liuhui.xlceremony.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhui.xlceremony.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SettingSafePhoneActivity extends BaseActivity implements View.OnClickListener {


	@InjectView(R.id.actionBarTitle)
	TextView title;
	@InjectView(R.id.back)
	ImageView imageView;


	@Override
	protected void initViews() {
		setContentView(R.layout.activity_setting_safe_phone);

		ButterKnife.inject(this);
		title.setText(R.string.setting_safe_edit_phone_title);
		imageView.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		finish();
	}
}
