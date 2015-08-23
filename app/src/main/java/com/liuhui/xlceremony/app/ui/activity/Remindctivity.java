package com.liuhui.xlceremony.app.ui.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.RemindListAadapter;

import java.util.LinkedList;
import java.util.List;

public class Remindctivity extends FragmentActivity implements View.OnClickListener {

    private ListView listView;
    private ImageView remind_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remindctivity);

        remind_back= (ImageView) findViewById(R.id.remind_back);

        listView= (ListView) findViewById(R.id.remind_list_view);

        List<String> list=new LinkedList<String>();
        list.add("11");
        list.add("22");
        list.add("33");

        RemindListAadapter aadapter=new RemindListAadapter(this,list);
        listView.setAdapter(aadapter);


        remind_back.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.remind_back:
                onBackPressed();
                break;
        }
    }
}
