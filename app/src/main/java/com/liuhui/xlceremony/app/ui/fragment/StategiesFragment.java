package com.liuhui.xlceremony.app.ui.fragment;


import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * 情礼关系界面
 */
public class StategiesFragment extends BaseFragment {
    //FragmentTabhost
    private FragmentTabHost mTabHost;
    //布局填充器
    private LayoutInflater mLayoutInflater;
    //Fragment数组界面
    private Class mFragmentArray[] = { Fragment1.class, Fragment2.class };
    //选修卡文字
    private String mTextArray[] = {"方案","故事"};

    public StategiesFragment() {
        // Required empty public constructor
    }
    /**
     * 初始化组件
     */
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_stategies, container, false);
        mTabHost= (FragmentTabHost) view.findViewById(R.id.stategy_fragment_tab_host);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.stategy_fragment_real_tab_content);
        // 得到fragment的个数
        int count = mFragmentArray.length;
        for (int i = 0; i < count; i++) {
            // 给每个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextArray[i]);
            // 将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec.setIndicator(mTextArray[i]), mFragmentArray[i], null);
            // 设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.selector_tab_background);
            //getTabItemView(i);
        }
        return view;
    }

    /**
     * 给每个Tab按钮设置文字
     */
    private View getTabItemView(int index) {
        View view = mLayoutInflater.inflate(R.layout.fragment_stategies_item_view, null);
        TextView textView = (TextView) view.findViewById(R.id.fragment_stategies_tab_txt);
        textView.setText(mTextArray[index]);
        return view;
    }
//
//    /**
//     * 返回一个View对象, 作为当前Fragment的布局来展示.
//     */
//    
//    public View initView(LayoutInflater inflater, ViewGroup container) {
//        View view = inflater.inflate(R.layout.fragment_stategies, container, false);
//        mTabHost= (FragmentTabHost) view.findViewById(R.id.stategy_fragment_tab_host);
//        mTabHost.setup(getActivity(),getChildFragmentManager(),R.id.tabhost_title);
//        mTabHost.addTab(mTabHost.newTabSpec("tag").setIndicator("Name"),0);
//        return view;
//    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {

    }
}
