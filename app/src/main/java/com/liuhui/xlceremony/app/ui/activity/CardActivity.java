package com.liuhui.xlceremony.app.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.FindPagerAdapter;

public class CardActivity extends FragmentActivity implements View.OnClickListener {

    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

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
