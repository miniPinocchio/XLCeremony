package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.liuhui.xlceremony.app.R;

import java.util.List;

/**
 * Created by Administrator on 2015/8/23.
 */
public class FindKaquanAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public FindKaquanAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.find_list_item2,parent,false);
        }



        return convertView;
    }
}
