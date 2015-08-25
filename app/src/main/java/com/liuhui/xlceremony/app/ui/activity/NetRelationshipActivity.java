package com.liuhui.xlceremony.app.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.NetRelationshipAdapter;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class NetRelationshipActivity extends BaseActivity implements View.OnClickListener {

    private ListView mListView;
    private ArrayList<ArrayList<HashMap<String, Object>>> mArrayList;
    private NetRelationshipAdapter adapter;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_net_relationship);
        init();
    }

    private void init() {

        ImageView back = (ImageView) findViewById(R.id.back);
        mListView = (ListView) findViewById(R.id.net_list);
        initData();

        back.setOnClickListener(this);
        adapter = new NetRelationshipAdapter(mArrayList, this);
        adapter.setListener(this);
        mListView.setAdapter(adapter);
    }

    private void initData() {
        mArrayList = new ArrayList<ArrayList<HashMap<String, Object>>>();
        HashMap<String, Object> hashMap = null;
        ArrayList<HashMap<String, Object>> arrayListForEveryGridView;

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.personal_picutre);

        for (int i = 0; i < 3; i++) {
            arrayListForEveryGridView = new ArrayList<HashMap<String, Object>>();
            if (i < 2) {
                for (int j = 0; j < 8; j++) {
                    hashMap = new HashMap();
                    hashMap.put("personImg", bitmap);
                    hashMap.put("personName", "晓礼测试" + j);
                    arrayListForEveryGridView.add(hashMap);
                }
            } else {
                for (int j = 0; j < 12; j++) {
                    hashMap = new HashMap();
                    hashMap.put("personImg", bitmap);
                    hashMap.put("personName", "晓礼测试" + j);
                    arrayListForEveryGridView.add(hashMap);
                }
            }
            mArrayList.add(arrayListForEveryGridView);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.back:
                NetRelationshipActivity.this.finish();
                break;
            case R.id.net_grid_img:
                //TODO 跳转个人信息并显示
                ToastUtil.toastLong("是否加好友");
        }

    }
}
