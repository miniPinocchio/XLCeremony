package com.liuhui.xlceremony.app.ui.activity;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.ui.fragment.subfind.SmsFirstFragment;

public class SmsActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioGroup tabBar;
    private FragmentManager manager;
    private SmsFirstFragment fragment;

    private ImageView imgBack;


    private LinearLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);


        layout= (LinearLayout) findViewById(R.id.kaquan_statusbar);


        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else{
            layout.setVisibility(View.GONE);
        }




        imgBack= (ImageView) findViewById(R.id.sms_back);

        imgBack.setOnClickListener(this);

        tabBar= (RadioGroup) findViewById(R.id.news_tab_bar);
        //tabBar设置点击事件
        tabBar.setOnCheckedChangeListener( this);


        manager = getSupportFragmentManager();

        fragment = new SmsFirstFragment();


    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();


        switch (checkedId){


            case R.id.tab_home:  //����
                fragmentTransaction.replace(R.id.fragment_contion,fragment);
                break;
            case R.id.tab_read:   //�Ķ�
                break;
            case R.id.tab_video:    //����
                break;
            case R.id.tab_discover:    //����
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
