package com.liuhui.xlceremony.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.CommonAdapter;
import com.squareup.okhttp.Call;

import java.util.List;

import static com.squareup.okhttp.Call.*;

/**
 * Created from "com.liuhui.xlceremony.app.adapter".
 * User ：${Yan}[ZY] on 2015/8/19 0019 11:28
 * Email ：530412159@qq.com
 */
public class PersonalAdapter extends CommonAdapter {
	
	public PersonalAdapter(Context context, List list) {
		super(context,list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View ret = null;
		//处理 convertView
		if (convertView != null) {
			ret = convertView;
		} else {
			ret = mInflater.inflate(R.layout.list_item_personal, parent, false);
		}
		//处理Holder
		ViewHolder holder = (ViewHolder) ret.getTag();
		if (holder == null) {
			holder = new ViewHolder(ret);
			ret.setTag(holder);
		}
		holder.textView.setText((CharSequence) mDatas.get(position));
		return ret;
	}
	
	public class ViewHolder {
		public final ImageView imageView;
		public final TextView textView;
		public final ImageView imageBack;
		public final View root;
		
		public ViewHolder(View root) {
			imageView = (ImageView) root.findViewById(R.id.list_item_img);
			textView = (TextView) root.findViewById(R.id.list_item_txt);
			imageBack = (ImageView) root.findViewById(R.id.list_item_back);
			this.root = root;
		}
	}
}
