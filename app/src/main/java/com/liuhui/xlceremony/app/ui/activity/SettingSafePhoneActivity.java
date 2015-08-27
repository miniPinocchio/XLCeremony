package com.liuhui.xlceremony.app.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;


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
