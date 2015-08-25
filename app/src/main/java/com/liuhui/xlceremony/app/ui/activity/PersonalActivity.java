package com.liuhui.xlceremony.app.ui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class PersonalActivity extends BaseActivity implements View.OnClickListener {

	@InjectView(R.id.actionBarTitle)
	TextView title;
	@InjectView(R.id.back)
	ImageView imageView;
	
	@Override
	protected void initViews() {
		setContentView(R.layout.activity_personal);
		ButterKnife.inject(this);
		title.setText(R.string.personal_title);
		imageView.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		finish();
	}
}
