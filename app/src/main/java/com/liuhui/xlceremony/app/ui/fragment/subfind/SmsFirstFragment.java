package com.liuhui.xlceremony.app.ui.fragment.subfind;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.SmsAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/20.
 */
public class SmsFirstFragment extends Fragment implements View.OnClickListener {

    private ListView listView;
    private Context context;

    //用来存放小tab
    private String tab="tab-00";

    //存放ListView数据的list集合
    private List<String>list=new LinkedList<String>();

    //如果要动态添加tab，可以使用HorizontalListView

    //每个小tab
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;

    //用来存放每次点击的TextView
    private TextView textView;


    private SmsAdapter adapter;


    public SmsFirstFragment() {
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.sms_fragment,container,false);

        textView1= (TextView) ret.findViewById(R.id.txt_1);
        textView2= (TextView) ret.findViewById(R.id.txt_2);
        textView3= (TextView) ret.findViewById(R.id.txt_3);
        textView4= (TextView) ret.findViewById(R.id.txt_4);
        textView5= (TextView) ret.findViewById(R.id.txt_5);
        textView6= (TextView) ret.findViewById(R.id.txt_6);
        textView7= (TextView) ret.findViewById(R.id.txt_7);
        textView8= (TextView) ret.findViewById(R.id.txt_8);
        textView9= (TextView) ret.findViewById(R.id.txt_9);

        //
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);
        textView7.setOnClickListener(this);
        textView8.setOnClickListener(this);
        textView9.setOnClickListener(this);

        context=getActivity();


        listView= (ListView) ret.findViewById(R.id.sms_list);

        list=getList("tab-001");
        textView1.setTextColor(Color.parseColor("#DE1135"));
       // textView1.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);


        //
        textView=textView1;



        adapter = new SmsAdapter(context,list);
        adapter.setOnClickListener(this);
        listView.setAdapter(adapter);

        return ret;
    }

    @Override
    public void onClick(View v) {

        //先把颜色还原
        textView.setTextColor(Color.parseColor("#000000"));

        int id=v.getId();
        switch (id){
            case R.id.txt_1:
                textView=textView1;
                tab="tab-001";
                list.clear();
                list=getList(tab);
             //
                break;
            case R.id.txt_2:
                textView=textView2;
                tab="tab-002";
                list.clear();
                list=getList(tab);
                //Toast.makeText(context,String.valueOf(list.size()),Toast.LENGTH_LONG).show();
                break;
            case R.id.txt_3:
                textView=textView3;
                tab="tab-003";
                list.clear();
                list=getList(tab);
                break;
            case R.id.txt_4:
                textView=textView4;
                tab="tab-004";
                list.clear();
                list=getList(tab);
                break;
            case R.id.txt_5:
                textView=textView5;
                tab="tab-005";
                list.clear();
                list=getList(tab);
                break;
            case R.id.txt_6:
                textView=textView6;
                tab="tab-006";
                list.clear();
                list=getList(tab);
                break;
            case R.id.txt_7:
                textView=textView7;
                tab="tab-007";
                list.clear();
                list=getList(tab);
                break;
            case R.id.txt_8:
                textView=textView8;
                tab="tab-008";
                list.clear();
                list=getList(tab);
                break;
            case R.id.txt_9:
                textView=textView9;
                tab="tab-009";
                list.clear();
                list=getList(tab);
                break;
            case R.id.sms_button_send:
                Toast.makeText(getActivity(),"跳转到发送界面",Toast.LENGTH_LONG).show();
                break;
        }

        textView.setTextColor(Color.parseColor("#DE1135"));
       // textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        adapter = new SmsAdapter(context,list);
//        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);


    }


    //提取出来的一个方法
    private List<String> getList(String s){
       list.clear();
        for (int i = 0; i <10 ; i++) {
            list.add(s+"--"+"item"+i+"--幸福的美好生活来之不易，我们需要格外的珍惜，不要在你拥有的时候，轻易的失去。幸福的美好生活来之不易，我们需要格外的珍惜，不要在你拥有的时候，轻易的失去。");

        }
        return list;
    }
}
