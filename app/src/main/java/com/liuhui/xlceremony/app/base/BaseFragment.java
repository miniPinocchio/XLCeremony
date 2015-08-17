package com.liuhui.xlceremony.app.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.base
 * user  Pinocchio
 * Date 2015/8/17
 * Email:liu594545591@126.com
 */
public abstract class BaseFragment extends Fragment{
    public Activity mActivity;
    /**
     * Fragment当前状态是否可见
     */
    protected boolean isVisible;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            isVisible = true;
        } else {
            isVisible = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = initView(inflater,container);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (isVisible) {
            initData();
        }
    }

    /**
     * 子类必须实现此方法, 返回一个View对象, 作为当前Fragment的布局来展示.
     *
     * @return
     */
    public abstract View initView(LayoutInflater inflater,ViewGroup container);

    /**
     * 子类需要初始化自己的数据
     */
    public abstract void initData();
}

