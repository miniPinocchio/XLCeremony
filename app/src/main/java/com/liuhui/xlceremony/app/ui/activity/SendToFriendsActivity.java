package com.liuhui.xlceremony.app.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.ListFriendsViewpagerAdapter;
import com.liuhui.xlceremony.app.ui.customview.ClearEditText;
import com.liuhui.xlceremony.app.ui.fragment.FriendsListFragment;
import com.liuhui.xlceremony.app.ui.fragment.GroupListFragment;

import java.util.LinkedList;
import java.util.List;

public class SendToFriendsActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    private RadioGroup listGroup;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_to_friends);

        //TODO 搜索search 功能
        ImageView back = (ImageView) findViewById(R.id.back);
        TextView contacts = (TextView) findViewById(R.id.actionBarTitle);
        ClearEditText search = (ClearEditText) findViewById(R.id.search_contacts);

        back.setOnClickListener(this);
        contacts.setOnClickListener(this);

        listGroup = (RadioGroup) findViewById(R.id.realationship_list_group);

        viewpager = (ViewPager) findViewById(R.id.search_view_group);

        listGroup.setOnCheckedChangeListener(this);

        viewpager.addOnPageChangeListener(this);
        viewpager.setCurrentItem(0);

        FriendsListFragment listFragment = new FriendsListFragment();
        GroupListFragment groupListFragment = new GroupListFragment();

        List<Fragment> fragments = new LinkedList<Fragment>();
        fragments.add(listFragment);
        fragments.add(groupListFragment);
        ListFriendsViewpagerAdapter adapter = new ListFriendsViewpagerAdapter(
                getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
    }



    @Override
    public void onPageScrolled(int i, float v, int i1) {
        int currentItem = viewpager.getCurrentItem();
        switch (currentItem) {
            case 0:
                listGroup.check(R.id.realationship_list_group_button1);
                break;
            case 1:
                listGroup.check(R.id.realationship_list_group_button2);
                break;
        }
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.realationship_search_group_button1:
                viewpager.setCurrentItem(0);
                break;
            case R.id.realationship_search_group_button2:
                viewpager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.actionBarTitle:
                //TODO 全选联系人
                break;

        }
    }
}
