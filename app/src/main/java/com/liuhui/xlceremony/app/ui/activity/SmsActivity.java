package com.liuhui.xlceremony.app.ui.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.ui.fragment.subfind.SmsFirstFragment;

public class SmsActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioGroup tabBar;
    private FragmentManager manager;
    private SmsFirstFragment fragment;

    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        imgBack= (ImageView) findViewById(R.id.sms_back);

        imgBack.setOnClickListener(this);

        tabBar= (RadioGroup) findViewById(R.id.news_tab_bar);
        //tebBar设置点击事件
        tabBar.setOnCheckedChangeListener( this);


        manager = getSupportFragmentManager();

        fragment = new SmsFirstFragment();


    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();


        switch (checkedId){


            case R.id.tab_home:  //新闻
                fragmentTransaction.replace(R.id.fragment_contion,fragment);
                break;
            case R.id.tab_read:   //阅读
                break;
            case R.id.tab_video:    //视听
                break;
            case R.id.tab_discover:    //发现
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.sms_back:
                onBackPressed();
        }
    }
}
