package com.liuhui.xlceremony.app.ui.fragment;


import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseFragment;
import com.liuhui.xlceremony.app.ui.fragment.substategyfragment.Fragment1;
import com.liuhui.xlceremony.app.ui.fragment.substategyfragment.Fragment2;

/**
 * Created with Android Studio.
 * Project: com.liuhui.xlceremony.app.base
 * user  Ziv
 * Date 2015/8/17
 * Email:Ziv_Android@Outlook.com
 * 情礼攻略
 */
public class StategiesFragment extends BaseFragment {
    private ListView listView;
    private ViewPager viewPager;
    public StategiesFragment() {
        // Required empty public constructor
    }
    /**
     * 初始化组件
     */
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_stategies_multiple, container, false);
        listView= (ListView) inflater.inflate(R.layout.fragment_stategies_body,null).findViewById(R.id.fragment_stategies_list);
        viewPager= (ViewPager) view.findViewById(R.id.fragment_stategies_content);
        //viewPager.addView(listView);
        return view;
    }
    
    /**
     * 初始化数据
     */
    @Override
    public void initData() {

    }
}
