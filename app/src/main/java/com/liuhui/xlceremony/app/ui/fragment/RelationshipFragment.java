package com.liuhui.xlceremony.app.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.liuhui.xlceremony.app.R;

/**
 * A simple {@link Fragment} subclass.
 * 关系管理界面
 */
public class RelationshipFragment extends Fragment {


    public RelationshipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_relationship, container, false);
    }


}
