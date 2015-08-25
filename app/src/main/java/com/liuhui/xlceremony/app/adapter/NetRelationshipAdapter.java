package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.liuhui.xlceremony.app.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.adapter
 * user  Pinocchio
 * Date 2015/8/21
 * Email:liu594545591@126.com
 */
public class NetRelationshipAdapter extends BaseAdapter {
    private ArrayList<ArrayList<HashMap<String, Object>>> mList;
    private Context mContext;
    private String[] strings = {"最亲密排名", "志趣相投排名", "可能认识"};
    private View.OnClickListener listener;

    public NetRelationshipAdapter(ArrayList<ArrayList<HashMap<String, Object>>> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return mList.size()>0?mList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
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
                    (mContext).inflate(R.layout.net_relationship_item, parent, false);
            holder.textView = (TextView) convertView.findViewById(R.id.net_relationship_txt);
            holder.gridView = (GridView) convertView.findViewById(R.id.net_relationship_grid);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        if (mList != null) {
            if (holder.textView != null) {
                holder.textView.setText(strings[position]);
            }
            if (holder.gridView != null) {
                ArrayList<HashMap<String, Object>> arrayListForEveryGridView = mList.get(position);
                NetGridViewAdapter gridViewAdapter=new NetGridViewAdapter(arrayListForEveryGridView,mContext);
                holder.gridView.setAdapter(gridViewAdapter);
                gridViewAdapter.setListener(listener);
            }
        }
        return convertView;
    }

    private class ViewHolder {
        TextView textView;
        GridView gridView;
    }

}
