package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
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
 * Date 2015/8/22
 * Email:liu594545591@126.com
 */
public class RankListAdapter extends BaseAdapter {

    private Context context;

    private List<HashMap<String, Object>> rankList;

    private View.OnClickListener listener;
    private HashMap<String, Object> map;

    public RankListAdapter(Context context, List<HashMap<String, Object>> rankList) {
        this.context = context;
        this.rankList = rankList;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return rankList.size() > 0 ? rankList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return rankList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        }
        return 3;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        int viewType = getItemViewType(position);

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.relationship_rank_item, parent, false);

            holder.number = (TextView) convertView.findViewById(R.id.rank_number);
            holder.name = (TextView) convertView.findViewById(R.id.rank_name);
            holder.img = (ImageView) convertView.findViewById(R.id.rank_img);
            holder.score = (TextView) convertView.findViewById(R.id.rank_score);
            holder.score.setOnClickListener(listener);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (rankList != null) {
            map = rankList.get(position);
            String rankName = (String) map.get("rankName");
            Bitmap bitmap = (Bitmap) map.get("rankImg");
            double rankScore = Double.parseDouble(map.get("rankScore").toString());

            holder.img.setImageBitmap(bitmap);
            holder.name.setText(rankName);
            holder.score.setText(String.valueOf(rankScore));
        }

        switch (viewType) {
            case 0:
                convertView.setBackgroundResource(R.mipmap.rank_item1);
                break;
            case 1:
                 convertView.setBackgroundResource(R.mipmap.rank_item2);
                break;
            case 2:
                convertView.setBackgroundResource(R.mipmap.rank_item3);
                break;
            case 3:
                convertView.setBackgroundResource(R.mipmap.rank_item4);
                int rank =Integer.parseInt(map.get("rank").toString())+1;
                holder.number.setText(String.valueOf(rank));
                holder.score.setTextColor(Color.parseColor("#D9D9D9"));
                holder.score.setTextSize(20);
                break;
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView number;//排名
        TextView name;//昵称
        TextView score;//得分
        ImageView img;//头像

    }
}
