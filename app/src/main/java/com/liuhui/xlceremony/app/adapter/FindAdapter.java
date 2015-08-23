package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/23.
 */
public class FindAdapter extends BaseAdapter{

    private Context context;
    private List<Integer>list;
    private List<String>list2;

    public FindAdapter(Context context) {
        this.context = context;

        list = new LinkedList<Integer>();
        list.add(R.mipmap.find_1);
        list.add(R.mipmap.find_2);
        list.add(R.mipmap.find_3);
        list.add(R.mipmap.find_4);
        list.add(R.mipmap.find_5);
        list.add(R.mipmap.find_6);

        list2=new LinkedList<String>();
        list2.add("相册");
        list2.add("情礼提醒");
        list2.add("短信模板");
        list2.add("扫一扫");
        list2.add("我的卡券");
        list2.add("关怀话题");

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
        ViewHolder holder=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.fragment_find_item,parent,false);
            holder=new ViewHolder();
            holder.imageView= (ImageView) convertView.findViewById(R.id.find_item_image);
            holder.textView= (TextView) convertView.findViewById(R.id.find_item_txt);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(list.get(position));
        holder.textView.setText(list2.get(position));

        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
