package com.liuhui.xlceremony.app;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.liuhui.xlceremony.app.base.BaseActivity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SettingActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

	@InjectView(R.id.actionBarTitle)
	TextView title;

	@InjectView(R.id.actionBarRightText)
	TextView rightText;
	
	@InjectView(R.id.setting_list_view)
	ListView listView;
	@InjectView(R.id.back)
	ImageView imageView;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_setting);
		ButterKnife.inject(this);
		title.setText(R.string.setting_title);
		rightText.setText(R.string.edit);

		imageView.setOnClickListener(this);


		String[] str ={"安全设置","通知设置"};
		int[] img={R.drawable.ic_action_arrow_right,R.drawable.ic_action_arrow_right};
		LinkedList<Map<String, Object>> data = new LinkedList<Map<String, Object>>();
		for (int i = 0; i < str.length; i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("txt",str[i]);
			hashMap.put("img",img[i]);
			data.add(hashMap);
		}

		SimpleAdapter adapter = new SimpleAdapter(
				this,
				data,
				R.layout.list_item_setting,
				new String[]{"txt","img"},
				new int[]{R.id.setting_list_item_txt,R.id.setting_list_item_back}
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
				Intent intent = new Intent(this, SettingSafeActivity.class);
				startActivity(intent);
				break;
		
		}
	}
}
