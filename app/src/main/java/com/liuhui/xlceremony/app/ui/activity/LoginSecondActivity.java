package com.liuhui.xlceremony.app.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.liuhui.xlceremony.app.App;
import com.liuhui.xlceremony.app.MainActivity;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.bean.ResponseBody;
import com.liuhui.xlceremony.app.constant.Api;
import com.liuhui.xlceremony.app.constant.RequestParam;
import com.liuhui.xlceremony.app.util.LogUtil;
import com.liuhui.xlceremony.app.util.OkHttpUtil;
import com.liuhui.xlceremony.app.util.ToastUtil;
import com.squareup.okhttp.*;

import java.io.IOException;

public class LoginSecondActivity extends BaseActivity {

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
    @OnClick(value = {R.id.back, R.id.actionBarRightText, R.id.goHome,
            R.id.login, R.id.register, R.id.forgetPassword})
    void setClickEvent(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.actionBarRightText:
                break;
            case R.id.goHome:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.login:
                login();
                break;
            case R.id.register:
                startActivity(new Intent(this, RegisterActivity.class));
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

        if (strMobilePhone.length() == 0) {
//            App.toast("未输入手机号");
//            Toast.makeText(this,"未输入手机号",Toast.LENGTH_LONG).show();
            ToastUtil.toastLong("未输入手机号");
            return;
        } else if (strMobilePhone.length() < 11 && strMobilePhone.length() > 0) {
            ToastUtil.toastLong("手机号未输入完整");
            return;
        } else if (!App.isMobilePhone(strMobilePhone)) {
            ToastUtil.toastLong("不存在此手机号");
            return;
        } else if (strPassword.length() == 0) {
            ToastUtil.toastLong("未输入密码");
            return;
        } else if (strPassword.length() < 6) {
            ToastUtil.toastLong("密码未输入完整");
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.toastLong("登录失败，请重试");
                    }
                });
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final ResponseBody responseBody = new Gson().fromJson(response.body().string(),
                        ResponseBody.class);
                LogUtil.e(responseBody.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseBody.getStatus().equals("1")) {
                            startActivity(new Intent(LoginSecondActivity.this, MainActivity.class));
                            finish();
                        } else if (responseBody.getStatus().equals("0")) {
                            ToastUtil.toastLong("登录失败，请重试");
                        }
                    }
                });
            }
        });
    }
}
