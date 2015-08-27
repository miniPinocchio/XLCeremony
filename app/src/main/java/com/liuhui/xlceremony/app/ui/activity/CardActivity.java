package com.liuhui.xlceremony.app.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.FindPagerAdapter;

public class CardActivity extends FragmentActivity implements View.OnClickListener {

    private ImageView imgBack;

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        layout= (LinearLayout) findViewById(R.id.kaquan_statusbar);


        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else{
            layout.setVisibility(View.GONE);
        }




        imgBack= (ImageView) findViewById(R.id.card_back);
        imgBack.setOnClickListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_kaquan);
        TabLayout.Tab tab=tabLayout.newTab();


        tabLayout.addTab(tabLayout.newTab().setText("可用卡券"));
        tabLayout.addTab(tabLayout.newTab().setText("历史卡券"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager_kaquan);
        final FindPagerAdapter adapter = new FindPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
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
            case R.id.card_back:
                onBackPressed();
        }
    }
}
