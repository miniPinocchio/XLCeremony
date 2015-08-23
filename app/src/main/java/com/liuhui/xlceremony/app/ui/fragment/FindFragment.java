package com.liuhui.xlceremony.app.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.FindAdapter;

import org.w3c.dom.ProcessingInstruction;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *发现界面
 */
public class FindFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<Integer> list;
    private Context context;


    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret=inflater.inflate(R.layout.fragment_find, container, false);

        context = getActivity();

        listView= (ListView) ret.findViewById(R.id.list_view_find);

        list = new LinkedList<Integer>();
        list.add(R.mipmap.find_01);
        list.add(R.mipmap.find_02);
        list.add(R.mipmap.find_03);
        list.add(R.mipmap.find_04);
        list.add(R.mipmap.find_05);
        list.add(R.mipmap.find_06);

        FindAdapter adapter=new FindAdapter(context, list);
        listView.setAdapter(adapter);

        //listView.setOnItemClickListener(this);

        return ret;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Toast.makeText(context,"相册",Toast.LENGTH_LONG).show();
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }
    }
}
