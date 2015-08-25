package com.liuhui.xlceremony.app.ui.activity;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.RemindListAadapter;

import java.util.LinkedList;
import java.util.List;

public class Remindctivity extends FragmentActivity implements View.OnClickListener {

    private ListView listView;
    private ImageView remind_back;
    private List<String> list;
    private RemindListAadapter adapter;

    private TextView txtNew;

    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remindctivity);


        layout= (LinearLayout) findViewById(R.id.kaquan_statusbar);


        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else{
            layout.setVisibility(View.GONE);
        }





        txtNew= (TextView) findViewById(R.id.find_remind_new);

        remind_back= (ImageView) findViewById(R.id.remind_back);

        listView= (ListView) findViewById(R.id.remind_list_view);

        list = new LinkedList<String>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        list.add("55");
        list.add("66");

        adapter = new RemindListAadapter(this, list);

        adapter.setOnClickListener(this);

        listView.setAdapter(adapter);


        remind_back.setOnClickListener(this);
        txtNew.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.remind_back:
                onBackPressed();
                break;
            case R.id.remind_del:
                int position= (Integer) v.getTag();
                list.remove(position);
                Log.d("laine11",position+"");
                Log.d("laine11",list.toString());

                adapter.notifyDataSetChanged();
                break;
            case R.id.find_remind_new:
                Toast.makeText(this,"跳转到新建提醒界面",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
