package com.liuhui.xlceremony.app;


import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liuhui.xlceremony.app.adapter.PersonalAdapter;
import com.liuhui.xlceremony.app.base.BaseFragment;
import com.liuhui.xlceremony.app.util.ToastUtil;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment implements AdapterView.OnItemClickListener {


	private PersonalAdapter adapter;

	@Override
	public View initView(LayoutInflater inflater, ViewGroup container) {
		View ret = inflater.inflate(R.layout.fragment_my, container, false);
		//设置actionbar的标题
		TextView title = (TextView) ret.findViewById(R.id.actionBarTitle);
		title.setText(R.string.me_title);
		
		//删除 返回图标
		RelativeLayout actionBar = (RelativeLayout) ret.findViewById(R.id.action_bar_xl);
		View backImage = ret.findViewById(R.id.back);
		actionBar.removeView(backImage);
		
		//为ListView 赋值
		ListView listView=(ListView) ret.findViewById(R.id.list_view_personal);
		
		//设置ListView的Header
		View header = inflater.inflate(R.layout.list_item_personal_header, null);
		AbsListView.LayoutParams layoutParams= new AbsListView.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				100
		);
		
		header.setLayoutParams(layoutParams);
		listView.addHeaderView(header);
		
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("打分记录");
		list.add("印象记录");
		list.add("我的故事");
		list.add("我的收藏");
		list.add("情礼记录");
		list.add("设置");
		adapter = new PersonalAdapter(this.getActivity(), list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		
		return ret;
	}

	@Override
	public void initData() {

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position){
			case 0:
				ToastUtil.toastShort("跳转Activity");
				Intent intent = new Intent(this.getActivity(), PersonalActivity.class);
				startActivity(intent);
				break;
			case 5:
				ToastUtil.toastShort("跳转Activity.....55555");
				Intent intent1 = new Intent(this.getActivity(), PresentRecorderActivity.class);
				startActivity(intent1);
				break;
			
			case 6:
				ToastUtil.toastShort("跳转Activity....66666");
				Intent intent2 = new Intent(this.getActivity(), SettingActivity.class);
				startActivity(intent2);
				break;
		}
	}
}
