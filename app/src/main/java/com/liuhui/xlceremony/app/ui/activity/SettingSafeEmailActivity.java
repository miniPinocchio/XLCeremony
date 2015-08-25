package com.liuhui.xlceremony.app.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SettingSafeEmailActivity extends BaseActivity implements View.OnClickListener {

	@InjectView(R.id.actionBarTitle)
	TextView title;

	@InjectView(R.id.back)
	ImageView imageView;
	

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_setting_safe_email);
		ButterKnife.inject(this);
//		title.setText(R.string.setting_title);
		imageView.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		finish();
	}
}
