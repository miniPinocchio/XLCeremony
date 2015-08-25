package com.liuhui.xlceremony.app.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.util.ToastUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SettingSafeActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

	@InjectView(R.id.actionBarTitle)
	TextView title;

	@InjectView(R.id.actionBarRightText)
	TextView rightText;

	@InjectView(R.id.setting_safe_list_view)
	ListView listView;
	@InjectView(R.id.back)
	ImageView imageView;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_setting_safe);
		ButterKnife.inject(this);
		title.setText(R.string.setting_title);
		rightText.setText(R.string.edit);
		imageView.setOnClickListener(this);

		ArrayAdapter<String> adapter = new ArrayAdapter<>(
				this,
				R.layout.list_item_setting,
				R.id.setting_list_item_txt,
				new String[]{
						"更改手机设置",
						"绑定邮箱",
						"修改密码",
						"微博绑定",
						"微信绑定"
				}
		);

		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);

	}

	@Override
	public void onClick(View v) {
		finish();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position){
			case 0:
				ToastUtil.toastShort("Jump to bug");
				startActivity(new Intent(this,SettingSafePhoneActivity.class));
				break;
			case 1:
				ToastUtil.toastLong("Jump to deBug");
		}
	}
}
