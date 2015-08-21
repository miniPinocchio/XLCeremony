package com.liuhui.xlceremony.app.ui.activity;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;

public class ContactsManagerActivity extends BaseActivity {

    private String[] contacts = new String[]{"联系人分组", "更新通讯录", "通讯录备份", "通讯录回复"};

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_contacts_manager);
        ListView listView = (ListView) findViewById(R.id.contacts_manager);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.relationship_contacts_manager_item
                , R.id.contacts_manager_txt, contacts);
        listView.setAdapter(adapter);

    }
}
