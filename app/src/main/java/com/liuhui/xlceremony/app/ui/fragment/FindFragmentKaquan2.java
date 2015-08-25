package com.liuhui.xlceremony.app.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.FindKaquanAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/21.
 */
public class FindFragmentKaquan2 extends Fragment {

    private ListView listView;
    private Context context;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View ret=inflater.inflate(R.layout.find_fragment_kaquan_2, container, false);

        listView= (ListView) ret.findViewById(R.id.list_view_yiyong);
        context=getActivity();

        list=new LinkedList<String>();
        for (int i = 0; i <10; i++) {
            list.add(""+i);

        }

        FindKaquanAdapter adapter=new FindKaquanAdapter(context,list);

        listView.setAdapter(adapter);
        return ret;
    }
}
