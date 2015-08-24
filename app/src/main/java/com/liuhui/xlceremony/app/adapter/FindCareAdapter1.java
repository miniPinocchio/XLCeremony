package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.bean.CareItem;

import java.util.List;

/**
 * Created by Administrator on 2015/8/12.
 */

/**
 *    购物车的Adapter
 */
public class FindCareAdapter1 extends BaseAdapter {

    private Context context;
    private List<CareItem>items;


    public ImageView imageView;
    private TextView txtTitle;

    //设置ImageView的点击事件
    private View.OnClickListener onClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    //当前adapter的模式，包含 编辑模式和普通模式
    //private int mode;

    //购物者加号和减号点击的事件，从外部传进来的
    //private View.OnClickListener onClickListener;



    //修改


    public FindCareAdapter1(Context context, List<CareItem> items) {
        this.context = context;
        this.items = items;
    }

   // public void setOnClickListener(View.OnClickListener onClickListener) {
     //   this.onClickListener = onClickListener;
    //}

    /**
     *   切换编辑模式  普通模式为0，编辑模式为1
     */
//    public void switchEditMode(){
//        if(mode==1){
//            mode=0;
//        }else if(mode==0){
//            mode=1;
//        }
//
//        notifyDataSetChanged();
//    }


    @Override
    public int getCount() {
        int ret=0;
        if (items != null) {
            ret=items.size();
        }
        
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret=null;
        if (convertView != null) {
            ret=convertView;
        }else{
            LayoutInflater inflater=LayoutInflater.from(context);
            ret=inflater.inflate(R.layout.find_care_item1,parent,false);

        }




           imageView= (ImageView) ret.findViewById(R.id.care_item1_image);
            txtTitle= (TextView) ret.findViewById(R.id.care_item1_txt);

            imageView.setImageResource(items.get(position).getResId());
            txtTitle.setText(items.get(position).getTitle());

            imageView.setOnClickListener(onClickListener);

            //chbCheck.setChecked(items.get(position).isChecked());




        //////////////////////////////////////////////////
        //设置数据


        //！！！只要更新CartItem的count，再更新Adapter，就好了


        /////////////////////////////////////////////////////////////

        //holder来设置按钮的 索引位置，当点击的时候，判断一下这个位置



        //控制编辑模式的显示


        //所有的代码调用setChecked（）就会触发接口回调
        //！！！！！！因此必须要先设置Tag，再设置选中


        return ret;
    }


//    private class ViewHolder{
//        public ImageView icon;
//        public TextView txtName;
//        public Button btnInc;
//        public Button btnDec;
//        public EditText txtCount;
//
//        //编辑模式才出现的内容
//        public CheckBox chbCheck;
//
//
//    }
}
