package com.liuhui.xlceremony.app.ui.fragment;


import android.content.Context;
import android.content.Intent;
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
import com.liuhui.xlceremony.app.ui.activity.CardActivity;
import com.liuhui.xlceremony.app.ui.activity.CareActivity;
import com.liuhui.xlceremony.app.ui.activity.PhotoActivity;
import com.liuhui.xlceremony.app.ui.activity.Remindctivity;
import com.liuhui.xlceremony.app.ui.activity.SmsActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *发现界面
 */
public class FindFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;

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



        FindAdapter adapter=new FindAdapter(context);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        return ret;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                //Toast.makeText(context,"相册",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getActivity(),PhotoActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1=new Intent(getActivity(), Remindctivity.class);
                startActivity(intent1);

                break;
            case 2:
                Intent intent2=new Intent(getActivity(), SmsActivity.class);
                startActivity(intent2);

                break;
            case 3:

                break;
            case 4:
                Intent intent4=new Intent(getActivity(), CardActivity.class);
                startActivity(intent4);

                break;
            case 5:
                Intent intent5=new Intent(getActivity(), CareActivity.class);
                startActivity(intent5);

                break;
        }
    }
}
