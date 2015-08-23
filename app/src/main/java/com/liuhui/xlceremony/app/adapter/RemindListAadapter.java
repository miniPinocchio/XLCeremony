package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;

import java.util.List;

/**
 * Created by Administrator on 15-8-19.
 */
public class RemindListAadapter extends BaseAdapter {

    private Context context;
    private List<String>array;
    private TextView txtCount;

    public RemindListAadapter(Context context, List<String> array) {
        this.context = context;
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.remind_list_item,parent,false);
            txtCount= (TextView) convertView.findViewById(R.id.txt_count);
        }

        txtCount.setText("还有"+array.get(position)+"天");
        return convertView;
    }
}
