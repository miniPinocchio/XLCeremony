package com.liuhui.xlceremony.app.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.FindCartAdapter;
import com.liuhui.xlceremony.app.bean.FindCardItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/21.
 */
public class FindFragmentKaquan extends Fragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private TextView textView;
    private ListView listView;
    private Context context;
    //用来记录点击的item
    private List<Integer>list=new LinkedList<Integer>();
    private List<FindCardItem> items;
    private FindCartAdapter adapter;

    private Button btn_send;
    private Button btn_cancel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.find_fragment_kaquan, container, false);

        btn_send= (Button) ret.findViewById(R.id.kaquan_send);
        btn_cancel= (Button) ret.findViewById(R.id.kaquan_cancel);
        btn_send.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);


        listView= (ListView) ret.findViewById(R.id.list_view_1);

        context=getActivity();
        textView= (TextView) ret.findViewById(R.id.text_01);

        items = new LinkedList<FindCardItem>();
        for (int i = 0; i <10 ; i++) {
            FindCardItem item=new FindCardItem();
            item.setResId(R.mipmap.img_kaquan);
            item.setIsChecked(false);
            items.add(item);

        }

        textView.setText("有"+ items.size()+"个卡券可以使用");

        adapter = new FindCartAdapter(context, items);

        listView.setAdapter(adapter);


        //设置adapter的点击处理事件，设置按钮点击事件
        adapter.setOnCheckedChangeListener(this);



        return ret;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        //Toast.makeText(context,"13",Toast.LENGTH_LONG).show();

        int id=buttonView.getId();

        if(id==R.id.item_cart_check){
            Object tag=buttonView.getTag();
            if(tag!=null && tag instanceof Integer){
                int position=(Integer)tag;
                list.add(position);
                //items.get(position).setIsChecked(isChecked);
                adapter.notifyDataSetChanged();
                //Toast.makeText(getActivity(),"点击次数"+count,Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.kaquan_send:
                Toast.makeText(context,"选择的卡券是"+list.toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.kaquan_cancel:
                Toast.makeText(context,"取消",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
