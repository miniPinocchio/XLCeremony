package com.liuhui.xlceremony.app.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.util.ToastUtil;

public class ContactsListGroupActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private String [] group = {"联系人分组","更新通讯录","通讯录备份","通讯录恢复"};

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_contacts_list_group);
        ListView contactsList = (ListView) findViewById(R.id.contacts_list_group);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_contacts_list_group_item
                , R.id.contacts_list_group_item_txt, group);
        contactsList.setAdapter(adapter);
        contactsList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this,ContactsListGroupActivity.class));
                break;
            case 1:
                ToastUtil.toastLong("更新通讯录");
                break;
            case 2:
                ToastUtil.toastLong("通讯录备份");
                break;
            case 3:
                ToastUtil.toastLong("通讯录恢复");
                break;

        }
    }
}
