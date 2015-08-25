package com.liuhui.xlceremony.app.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ListView;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.RankListAdapter;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RelationshipRankActivity extends BaseActivity implements View.OnClickListener {


    private List<HashMap<String,Object>> rankList;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_relationship_rank);

        ListView rankListView = (ListView) findViewById(R.id.rank_list_view);
        initData();

        RankListAdapter adapter = new RankListAdapter(this,rankList);

        adapter.setListener(this);

        rankListView.setAdapter(adapter);

    }

    private void initData() {
        rankList = new ArrayList<HashMap<String,Object>>();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.github);

        for (int i = 0; i < 10; i++) {
            HashMap<String,Object> maps= new HashMap();
            maps.put("rank",i);
            maps.put("rankImg",bitmap);
            maps.put("rankName","B神"+i);
            maps.put("rankScore",String.valueOf(9.0-0.1*i));
            rankList.add(maps);
        }

    }

    @Override
    public void onClick(View v) {
        ToastUtil.toastLong("点击");
    }
}
