package com.liuhui.xlceremony.app.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseFragment;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.ui.fragment
 * user  Pinocchio
 * Date 2015/8/20
 * Email:liu594545591@126.com
 */
public class FriendsListFragment extends BaseFragment {


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.
                inflate(R.layout.fragment_relationship_list_group,
                        container, false);
        return view;
    }

    @Override
    public void initData() {


    }
}
