package com.liuhui.xlceremony.app.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.FindCareAdapter1;
import com.liuhui.xlceremony.app.bean.CareItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/21.
 */
public class FindCareFragment1 extends Fragment implements  View.OnClickListener {


    private ListView listView;
    private Context context;

    private List<CareItem> items;
    private FindCareAdapter1 adapter;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.find_fragment_care1, container, false);



        listView= (ListView) ret.findViewById(R.id.list_view_1);

        context=getActivity();

        int[]images={R.mipmap.care_01, R.mipmap.care_02,R.mipmap.care_03};


        items = new LinkedList<CareItem>();
        for (int i = 0; i <10 ; i++) {
            CareItem item=new CareItem();
            item.setResId(images[i%3]);
            item.setTitle("正文简短摘要内容正文简短摘要内容正文简短摘要内容正文简短摘要内容正文简短摘要内容正文简短摘要内容正文简短摘要内容");
            items.add(item);

        }



        adapter = new FindCareAdapter1(context, items);

        listView.setAdapter(adapter);


        //设置adapter的点击处理事件，设置按钮点击事件
        adapter.setOnClickListener(this);



        return ret;
    }




    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.care_item1_image:
                Toast.makeText(context,"跳转到详情页面",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
