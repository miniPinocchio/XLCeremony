package com.liuhui.xlceremony.app.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.liuhui.xlceremony.app.App;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.base.BaseActivity;
import com.liuhui.xlceremony.app.bean.ResponseBody;
import com.liuhui.xlceremony.app.constant.Api;
import com.liuhui.xlceremony.app.constant.AuthCode;
import com.liuhui.xlceremony.app.constant.RequestParam;
import com.liuhui.xlceremony.app.util.LogUtil;
import com.liuhui.xlceremony.app.util.OkHttpUtil;
import com.liuhui.xlceremony.app.util.ToastUtil;
import com.squareup.okhttp.*;

import java.io.IOException;

public class RegisterActivity extends BaseActivity {
    @InjectView(R.id.mobilePhone)
    EditText mobilePhone;

    @InjectView(R.id.password)
    EditText password;

    @InjectView(R.id.confirmPassword)
    EditText confirmPassword;

    @InjectView(R.id.authCode)
    EditText authCode;

    private String strAuthCode;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_register_fragment);
        ButterKnife.inject(this);
        TextView title = ButterKnife.findById(this, R.id.actionBarTitle);
        title.setText(R.string.register_title);
    }

    /**
     * 设置按钮的点击事件
     */
    @OnClick(value = { R.id.back, R.id.register, R.id.getAuthCode })
    void setClickEvent(View v) {
        switch(v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.register:
                register();
                break;
            case R.id.getAuthCode:
                getAuthCode();
                break;
        }
    }

    /**
     * 获取短信验证码操作
     */
    private void getAuthCode() {
        String strMobilePhone = mobilePhone.getText().toString();
        if(strMobilePhone.length() == 0) {
            ToastUtil.toastLong("未输入手机号");
            return;
        } else if(strMobilePhone.length() < 11) {
            ToastUtil.toastLong("手机号未输入完整");
            return;
        } else if(!App.isMobilePhone(strMobilePhone)) {
            ToastUtil.toastLong("不存在此手机号");
            return;
        }

        RequestBody requestBody = new FormEncodingBuilder()
                .add(RequestParam.MOBILE, strMobilePhone)
                .build();

        Request loginRequest = new Request.Builder()
                .url(Api.GET_AUTH_CODE)
                .post(requestBody)
                .build();

        OkHttpUtil.enqueue(loginRequest, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.toastLong("获取验证码失败，请重试");
                    }
                });
            }

            @Override
            public void onResponse(Response response) throws IOException {
                AuthCode objAuthCode = new Gson().fromJson(response.body().string(),
                        AuthCode.class);
                strAuthCode = objAuthCode.getPincode();
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        ToastUtil.toastLong(strAuthCode);
                        authCode.setText(strAuthCode);
                    }
                });
            }
        });
    }

    /**
     * 注册操作
     */
    private void register() {
        String strMobilePhone = mobilePhone.getText().toString();
        String strPassword = password.getText().toString();
        String strConfirmPassword = confirmPassword.getText().toString();
        String strAuthCode = authCode.getText().toString();

        if(strMobilePhone.length() == 0) {
            ToastUtil.toastLong("未输入手机号");
            return;
        } else if(strMobilePhone.length() < 11) {
            ToastUtil.toastLong("手机号未输入完整");
            return;
        } else if(!App.isMobilePhone(strMobilePhone)) {
            ToastUtil.toastLong("不存在此手机号");
            return;
        } else if(strPassword.length() == 0 || strConfirmPassword.length() == 0) {
            ToastUtil.toastLong("未输入密码");
            return;
        } else if(strPassword.length() < 6 || strConfirmPassword.length() == 0) {
            ToastUtil.toastLong("密码未输入完整");
            return;
        } else if(!strPassword.equals(strConfirmPassword)) {
            ToastUtil.toastLong("两次输入的密码不一致");
            return;
        } else if(strAuthCode.length() == 0) {
            ToastUtil.toastLong("未输入短信验证码");
            return;
        } else if(!strAuthCode.equals(this.strAuthCode)) {
            ToastUtil.toastLong("短信验证码输入错误");
            return;
        }

        //TODO 暂时为手机号参数
        RequestBody requestBody = new FormEncodingBuilder()
                .add(RequestParam.MOBILE, strMobilePhone)
                .add(RequestParam.SMS_CONTENT, strPassword).build();
//                .add(RequestParam.AUTH_CODE, strAuthCode)
//                .build();

        Request loginRequest = new Request.Builder()
                .url(Api.REGISTER)
                .post(requestBody)
                .build();

        OkHttpUtil.enqueue(loginRequest, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.toastLong("注册失败，请重试");
                    }
                });
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final ResponseBody responseBody = new Gson().fromJson(response.body().string(),
                        ResponseBody.class);
                LogUtil.e(response.body().string());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseBody.getStatus().equals("1")) {
                            ToastUtil.toastLong("注册成功");
                            finish();

                        } else if (responseBody.getStatus().equals("0")) {
                            ToastUtil.toastLong("注册失败，请重试");

                        }
                    }
                });
            }
        });
    }
}
