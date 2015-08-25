package com.liuhui.xlceremony.app.ui.activity;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.CarePagerAdapter;

public class CareActivity extends FragmentActivity implements View.OnClickListener {

    //返回按钮
    private ImageView imgBack;

    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);


        layout= (LinearLayout) findViewById(R.id.kaquan_statusbar);


        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else{
            layout.setVisibility(View.GONE);
        }




        imgBack= (ImageView) findViewById(R.id.care_back);
        imgBack.setOnClickListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_kaquan);
        TabLayout.Tab tab=tabLayout.newTab();


        tabLayout.addTab(tabLayout.newTab().setText("近期话题"));
        tabLayout.addTab(tabLayout.newTab().setText("精品关怀"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager_kaquan);
        final CarePagerAdapter adapter = new CarePagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });




    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.care_back:
                onBackPressed();
                break;
        }
    }
}
