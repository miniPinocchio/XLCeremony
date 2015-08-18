package com.liuhui.xlceremony.app.ui.activity;

import android.content.Intent;
import android.os.Handler;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;

public class SplashActivity extends BaseActivity {


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginSecondActivity.class));
                finish();
            }
        }, 2000);
    }

}
