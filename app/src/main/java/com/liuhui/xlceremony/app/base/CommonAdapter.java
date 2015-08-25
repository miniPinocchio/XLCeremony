package com.liuhui.xlceremony.app.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created from "com.liuhui.xlceremony.app.base".
 * User ：${Yan}[ZY] on 2015/8/21 0021 16:27
 * Email ：530412159@qq.com
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
	protected LayoutInflater mInflater;
	protected Context mContext;
	protected List<T> mDatas;

	public CommonAdapter(Context context, List<T> mDatas) {
		mInflater = (LayoutInflater)
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mContext = context;
		this.mDatas = mDatas;
	}

	@Override
	public int getCount() {
		int ret = 0;
		if (mDatas != null) {
			ret=mDatas.size();
		}
		return ret;
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	
}
