package com.liuhui.xlceremony.app.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.liuhui.xlceremony.app.App;
import com.liuhui.xlceremony.app.MainActivity;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.constant.Api;
import com.liuhui.xlceremony.app.constant.RequestParam;
import com.liuhui.xlceremony.app.util.LogUtil;
import com.liuhui.xlceremony.app.util.OkHttpUtil;
import com.squareup.okhttp.*;

import java.io.IOException;

public class LoginFragment extends BaseActivity {

    @InjectView(R.id.actionBarTitle)
    TextView title;

    @InjectView(R.id.actionBarRightText)
    TextView rightText;

    @InjectView(R.id.mobilePhone)
    EditText mobilePhone;

    @InjectView(R.id.password)
    EditText password;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_login_fragment);

        ButterKnife.inject(this);

        title.setText(R.string.login_title);
        rightText.setText(R.string.cancel);
    }

    /**
     * 设置按钮的点击事件
     */
    @OnClick(value = { R.id.back, R.id.actionBarRightText, R.id.goHome,
            R.id.login, R.id.register, R.id.forgetPassword })
    void setClickEvent(View v) {
        switch(v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.actionBarRightText:
                break;
            case R.id.goHome:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.login:
                startActivity(new Intent(this, MainActivity.class));
                login();
                break;
            case R.id.register:
                startActivity(new Intent(this, RegisterFragment.class));
                break;
            case R.id.forgetPassword:
                break;
        }
    }

    /**
     * 登录操作
     */
    private void login() {
        String strMobilePhone = mobilePhone.getText().toString();
        String strPassword = password.getText().toString();

        if(strMobilePhone.length() == 0) {
            App.toast("未输入手机号");
            return;
        } else if(strMobilePhone.length() < 11) {
            App.toast("手机号未输入完整");
            return;
        } else if(!App.isMobilePhone(strMobilePhone)) {
            App.toast("不存在此手机号");
            return;
        } else if(strPassword.length() == 0) {
            App.toast("未输入密码");
            return;
        } else if(strPassword.length() < 6) {
            App.toast("密码未输入完整");
            return;
        }

        RequestBody requestBody = new FormEncodingBuilder()
                .add(RequestParam.MOBILE, strMobilePhone)
                .add(RequestParam.PASSWORD, strPassword).build();

        Request loginRequest = new Request.Builder()
                .url(Api.LOGIN)
                .post(requestBody)
                .build();

        OkHttpUtil.enqueue(loginRequest, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                //				App.toast("登录失败，请重试");
                LogUtil.e("登录失败，请重试");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //				App.toast(response.body().string());
                LogUtil.e(response.body().string());
            }
        });
    }
}
