package com.liuhui.xlceremony.app.ui.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.util.ToastUtil;

public class ContactsManagerActivity extends BaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private String[] contacts = new String[]{"家人(32)", "朋友(62)", "同学(32)", "同事(62)"};

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_contacts_manager);
        ListView listView = (ListView) findViewById(R.id.contacts_manager);
        ImageView back = (ImageView) findViewById(R.id.back);


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.relationship_contacts_manager_item
                , R.id.contacts_manager_txt, contacts);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
//                startActivity(new Intent(this,ContactsListGroupActivity.class));
                ToastUtil.toastLong("家人");
                break;
            case 1:
                ToastUtil.toastLong("朋友");
                break;
            case 2:
                ToastUtil.toastLong("同学");
                break;
            case 3:
                ToastUtil.toastLong("同事");
                break;

        }
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
