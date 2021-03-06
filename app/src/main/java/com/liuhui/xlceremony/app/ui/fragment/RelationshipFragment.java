package com.liuhui.xlceremony.app.ui.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.ListFriendsViewpagerAdapter;
import com.liuhui.xlceremony.app.base.BaseFragment;
import com.liuhui.xlceremony.app.ui.activity.*;
import com.liuhui.xlceremony.app.util.LogUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 关系管理界面
 */
public class RelationshipFragment extends BaseFragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioGroup listGroup;
    private ViewPager viewpager;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        //TODO 关系图
        View view = inflater.inflate(R.layout.fragment_relationship, container, false);
        Button contacts = (Button) view.findViewById(R.id.relationship_contacts);
        Button netPicture = (Button) view.findViewById(R.id.relationship_net_picture);
        Button groupAssistant = (Button) view.findViewById(R.id.relationship_group_assistant);

        contacts.setOnClickListener(this);
        netPicture.setOnClickListener(this);
        groupAssistant.setOnClickListener(this);

        LinearLayout impress = (LinearLayout) view.findViewById(R.id.realationship_my_impress_linearlayout);
        LinearLayout rank = (LinearLayout) view.findViewById(R.id.realationship_my_rank_linearlayout);
        LinearLayout scores = (LinearLayout) view.findViewById(R.id.realationship_my_scores_linearlayout);

        impress.getChildAt(0).setOnClickListener(this);
        rank.getChildAt(0).setOnClickListener(this);
        scores.getChildAt(0).setOnClickListener(this);

        listGroup = (RadioGroup) view.findViewById(R.id.realationship_list_group);

        viewpager = (ViewPager) view.findViewById(R.id.relationship_viewpager);

        listGroup.setOnCheckedChangeListener(this);

        viewpager.addOnPageChangeListener(this);
        viewpager.setCurrentItem(0);

        FriendsListFragment listFragment = new FriendsListFragment();
        GroupListFragment groupListFragment = new GroupListFragment();

        List<Fragment> fragments = new LinkedList<Fragment>();
        fragments.add(listFragment);
        fragments.add(groupListFragment);
        ListFriendsViewpagerAdapter adapter = new ListFriendsViewpagerAdapter(
                getActivity().getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        return view;
    }

    @Override
    public void initData() {
        LogUtil.e("RelationshipFragment initData ---");
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
            case R.id.realationship_list_group_button1:
                viewpager.setCurrentItem(0);
                break;
            case R.id.realationship_list_group_button2:
                viewpager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.relationship_contacts:
                startActivity(new Intent(getActivity(), ContactsManagerActivity.class));
                break;
            case R.id.relationship_net_picture:
                startActivity(new Intent(getActivity(), NetRelationshipActivity.class));
                break;
            case R.id.relationship_group_assistant:
                startActivity(new Intent(getActivity(), SendToFriendsActivity.class));
                break;
            case R.id.my_rank_img:
                startActivity(new Intent(getActivity(), RelationshipRankActivity.class));
                break;
            case R.id.my_impress_img:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.my_score_img:

                break;
        }
    }
}