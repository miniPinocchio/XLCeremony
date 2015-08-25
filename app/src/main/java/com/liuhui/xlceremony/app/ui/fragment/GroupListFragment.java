package com.liuhui.xlceremony.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.PinnedHeaderExpandableAdapter;
import com.liuhui.xlceremony.app.ui.customview.PinnedHeaderExpandableListView;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.ui.fragment
 * user  Pinocchio
 * Date 2015/8/20
 * Email:liu594545591@126.com
 */
public class GroupListFragment extends Fragment {

    private PinnedHeaderExpandableListView explistview;
    private String[][] childrenData = new String[10][10];
    private String[] groupData = {"朋友","同事","家人","孩子","幼儿园","小学","初中","大学","高中","就业"};
    private int expandFlag = -1;//控制列表的展开
    private PinnedHeaderExpandableAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_group, container, false);


        initView(view);
        initData();
        return view;
    }

    /**
     * 初始化VIEW
     */
    private void initView(View view) {
        explistview = (PinnedHeaderExpandableListView) view.findViewById(R.id.explistview);
    }

    /**
     * 初始化数据
     */
    private void initData() {


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                childrenData[i][j] = "好友" + i + "-" + j;
            }
        }
        //设置悬浮头部VIEW
        explistview.setHeaderView(getActivity().getLayoutInflater().inflate(R.layout.fragment_list_group_head,
                explistview, false));
        adapter = new PinnedHeaderExpandableAdapter(childrenData, groupData, getActivity().getApplicationContext(), explistview);
        explistview.setAdapter(adapter);

        //设置单个分组展开
        explistview.setOnGroupClickListener(new GroupClickListener());
    }

    class GroupClickListener implements ExpandableListView.OnGroupClickListener {
        @Override
        public boolean onGroupClick(ExpandableListView parent, View v,
                                    int groupPosition, long id) {
            if (expandFlag == -1) {
                // 展开被选的group
                explistview.expandGroup(groupPosition);
                // 设置被选中的group置于顶端
                explistview.setSelectedGroup(groupPosition);
                expandFlag = groupPosition;
            } else if (expandFlag == groupPosition) {
                explistview.collapseGroup(expandFlag);
                expandFlag = -1;
            } else {
                explistview.collapseGroup(expandFlag);
                // 展开被选的group
                explistview.expandGroup(groupPosition);
                // 设置被选中的group置于顶端
                explistview.setSelectedGroup(groupPosition);
                expandFlag = groupPosition;
            }
            return true;
        }
    }

}