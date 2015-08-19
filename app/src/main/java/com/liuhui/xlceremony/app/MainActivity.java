package com.liuhui.xlceremony.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.ui.fragment.FindFragment;
import com.liuhui.xlceremony.app.ui.fragment.PersonalFragment;
import com.liuhui.xlceremony.app.ui.fragment.RelationshipFragment;
import com.liuhui.xlceremony.app.ui.fragment.StategiesFragment;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RelationshipFragment relationshipFragment;
    private FindFragment friendFragment;
    private PersonalFragment personalFragment;
    private StategiesFragment stategiesFragment;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.main_tab);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.tab_relationship);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fragment = null;
        switch (checkedId){
            case R.id.tab_relationship:
                if (relationshipFragment == null) {
                    relationshipFragment = new RelationshipFragment();
                }
                fragment = relationshipFragment;
                break;
            case R.id.tab_friend:
                if (friendFragment == null){
                    friendFragment = new FindFragment();
                }
                fragment = friendFragment;
                break;
            case R.id.tab_discover:
                if (stategiesFragment == null){
                    stategiesFragment = new StategiesFragment();
                }
                fragment = stategiesFragment;
                break;
            case R.id.tab_personal:
                if (personalFragment == null){
                    personalFragment = new PersonalFragment();
                }
                fragment = personalFragment;
                break;
        }
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }




}
