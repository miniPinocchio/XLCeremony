package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.liuhui.xlceremony.app.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.adapter
 * user  Pinocchio
 * Date 2015/8/21
 * Email:liu594545591@126.com
 */
public class NetGridViewAdapter extends BaseAdapter {

    private List<HashMap<String,Object>> lists;
    private View.OnClickListener listener;


    private Context context;
    private int positionM;

    public NetGridViewAdapter(List<HashMap<String, Object>> lists, Context context,View.OnClickListener listener
    ,int position) {
        this.lists = lists;
        this.context = context;
        this.listener = listener;
        this.positionM = position;
    }



    @Override
    public int getCount() {
        return lists.size()>0?lists.size():0;
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from
                    (context).inflate(R.layout.net_relationship_gridview_item, parent, false);
            holder.personImg = (ImageView) convertView.findViewById(R.id.net_grid_img);
            holder.personImg.setOnClickListener(listener);
            holder.personName = (TextView) convertView.findViewById(R.id.net_grid_txt);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (this.lists != null) {
            HashMap<String, Object> hashMap = lists.get(position);
            if (holder.personImg != null) {
                holder.personImg.setImageBitmap((Bitmap) hashMap.get("personImg"));
                holder.personImg.setOnClickListener(listener);
                holder.personImg.setTag(new int[]{positionM, position});
            }
                holder.personName.setText(hashMap.get("personName").toString());
        }
        return convertView;
    }

    private  class ViewHolder {
        ImageView personImg;
        TextView personName;
    }

}
