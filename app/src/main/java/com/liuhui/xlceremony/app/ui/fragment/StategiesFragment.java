package com.liuhui.xlceremony.app.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.StategyListAdapter;
import com.liuhui.xlceremony.app.adapter.StategytabAdapter;
import com.liuhui.xlceremony.app.base.BaseFragment;
import com.liuhui.xlceremony.app.bean.Stategy.StategyHead;
import com.liuhui.xlceremony.app.ui.fragment.substategyfragment.Fragment1;
import com.liuhui.xlceremony.app.ui.fragment.substategyfragment.Fragment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with Android Studio.
 * Project: com.liuhui.xlceremony.app.base
 * user  Ziv
 * Date 2015/8/17
 * Email:346549752@qq.com
 * 情礼攻略
 */
public class StategiesFragment extends BaseFragment {
    //标题行
    private List<String> tabs;
    private List<String> stategys;
    private List<String> items;
    //视图列表
    private ListView listView;
    private ListView detailsListView;
    private List<Map<String,String>> resources;
    //滑动视图
    private List<ListView> viewlists;
    private ViewPager viewPager;
    public StategiesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabs=new LinkedList<String>();
        stategys=new LinkedList<String>();
        items=new LinkedList<String>();
    }

    /**
     * 初始化组件
     */
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_stategies_multiple, container, false);



        viewlists=new ArrayList<ListView>();
        listView= (ListView) inflater.inflate(R.layout.fragment_stategies_body,null).findViewById(R.id.fragment_stategies_list);
        detailsListView= (ListView) inflater.inflate(R.layout.fragment_stategies_details_body,null).findViewById(R.id.fragment_stategies_details_list);

        viewlists.add(listView);
        viewlists.add(detailsListView);
        
        viewPager= (ViewPager) view.findViewById(R.id.fragment_stategies_content);
        //viewPager.setAdapter(new StategytabAdapter(viewlists));

        //ArrayAdapter

        SimpleAdapter listViewAdapter=new StategyListAdapter(
                getActivity(),
                resources,
                R.layout.fragment_stategies_body,
                new String[]{"image","love","txt","respond","browse","share","collection"},
                new int[]{
                        R.id.stategy_vertical_item_image,//主图
                        R.id.stategy_vertical_item_love,//赞
                        R.id.stategy_vertical_item_txt,//标题文本
                        R.id.stategy_vertical_item_respond,//回复
                        R.id.stategy_vertical_item_browse,//浏览
                        R.id.stategy_vertical_item_share,//分享
                        R.id.stategy_vertical_item_collection//收藏
                }
        );
//        if (listView != null) {
//            listView.setAdapter(listViewAdapter);
//        }
        SimpleAdapter detailsListViewAdapter=new StategyListAdapter(
                getActivity(),
                resources,
                R.layout.fragment_stategies_body,
                new String[]{"image","love","title","txt","details","share","collection"},
                new int[]{
                        R.id.fragment_stategies_details_body_image,//主图
                        R.id.fragment_stategies_details_body_love,//点赞
                        R.id.fragment_stategies_details_body_title,//标题                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           e,//标题文本
                        R.id.fragment_stategies_details_body_txt,//内容
                        R.id.fragment_stategies_details_body_details,//详情
                        R.id.fragment_stategies_details_body_share,//分享
                        R.id.fragment_stategies_details_body_collection//收藏
                }
        );
//        if (detailsListView != null) {
//            detailsListView.setAdapter(detailsListViewAdapter);
//        }
        return view;
    }
    
    /**
     * 初始化数据
     */
    @Override
    public void initData() {

    }
}
