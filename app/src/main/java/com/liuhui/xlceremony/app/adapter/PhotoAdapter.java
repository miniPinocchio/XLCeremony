package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.bean.Photo;
import com.liuhui.xlceremony.app.bean.SubPhoto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/22.
 */
public class PhotoAdapter extends BaseAdapter {

    private Context context;
    private List<Photo> list;






    //点击事件
    private View.OnClickListener onClickListener;
    private List<SubPhoto> subList2;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }



    public PhotoAdapter(Context context, List<Photo> list) {
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
        Log.d("laine135","111");


        View ret=null;
        if (convertView != null) {
            ret=convertView;
        }else{
            LayoutInflater inflater=LayoutInflater.from(context);
            ret=inflater.inflate(R.layout.find_list_item,parent,false);
        }
        ViewHolder holder= (ViewHolder) ret.getTag();

        if(holder==null){
            holder=new ViewHolder();

            holder.txtDay= (TextView) ret.findViewById(R.id.list_view_day);
            holder.txtMonth= (TextView) ret.findViewById(R.id.list_view_month);
            holder.txtMore= (TextView) ret.findViewById(R.id.list_view_more);
            holder.gridView= (GridView) ret.findViewById(R.id.grid_view);

            ret.setTag(holder);
        }

        //设置数据
        Photo photo=list.get(position);
        String day=photo.getDay()+"日";
        String month=photo.getYear()+"年"+photo.getMonth()+"月";

        holder.txtDay.setText(day);
        holder.txtMonth.setText(month);


        List<SubPhoto>subList = photo.getPhotoList();

        //设置button是否显示
        if(subList.size()<=6){
            holder.txtMore.setVisibility(View.GONE);
            subList2 = subList;

        }else{
            holder.txtMore.setVisibility(View.VISIBLE);

            //集合中的个数大于6个的话就截取前6个
            int clickCount=list.get(position).getClickCount();
            if(subList.size()>=(clickCount*6+6)){
                subList2 = subList.subList(0,6+6*clickCount);
            }else{
                subList2=subList;
            }

        }

        holder.txtMore.setOnClickListener(onClickListener);






        //设置GridView

        List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();

        for(int i=0;i<subList2.size();i++)
        {

            SubPhoto subPhoto= subList.get(i);
            int resId=subPhoto.getResId();
            String title=subPhoto.getTitle();

            Map<String,Object> map = new HashMap<String,Object>();
            map.put("title", title);
            map.put("image",resId);
            listMap.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(context,listMap, R.layout.find_grid_item, new String[]{"title","image"},new int[]{R.id.grid_image_title,R.id.grid_view_image});
        holder.gridView.setAdapter(adapter);

        holder.txtMore.setTag(position);

        return ret;
    }

    public class ViewHolder{
        public TextView txtDay;
        public TextView txtMonth;
        public TextView txtMore;
        public GridView gridView;
    }




}
