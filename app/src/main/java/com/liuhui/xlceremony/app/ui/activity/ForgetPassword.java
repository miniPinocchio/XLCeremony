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

public class ForgetPassword extends BaseActivity {

    @InjectView(R.id.mobilePhone)
    EditText mobilePhone;

    @InjectView(R.id.password)
    EditText password;

    @InjectView(R.id.confirmPassword)
    EditText confirmPassword;

    @InjectView(R.id.authCode)
    EditText authCode;

    @InjectView(R.id.verifiedMobilePhone)
    TextView verifiedMobilePhone;

    private String strAuthCode;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_forget_password);
        ButterKnife.inject(this);
        ((TextView) ButterKnife.findById(this, R.id.actionBarTitle))
                .setText(R.string.title_activity_forget_password);
    }

    @OnClick(value = { R.id.back, R.id.getAuthCode, R.id.confirm })
    void setClickEvent(View view) {
        switch(view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.getAuthCode:
                getAuthCode();
                break;
            case R.id.confirm:
                changePassword();
                break;
        }
    }

    /**
     * 获取短信验证码操作
     */
    private void getAuthCode() {
        final String strMobilePhone = mobilePhone.getText().toString();
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

        Request getAuthCodeRequest = new Request.Builder()
                .url(Api.GET_AUTH_CODE)
                .post(requestBody)
                .build();

        OkHttpUtil.enqueue(getAuthCodeRequest, new Callback() {
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
                        verifiedMobilePhone.setText("已验证手机：" + strMobilePhone);
                    }
                });
            }
        });
    }

    /**
     * 修改密码操作
     */
    private void changePassword() {
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

        final RequestBody requestBody = new FormEncodingBuilder()
                .add(RequestParam.MOBILE, strMobilePhone)
                .add(RequestParam.PASSWORD, strPassword)
                .add(RequestParam.AUTH_CODE, strAuthCode)
                .build();

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
                         ToastUtil.toastLong("修改密码失败，请重试");
                    }
                });
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final ResponseBody responseBody = new Gson().fromJson(response.body().string(),
                        ResponseBody.class);
                LogUtil.e(requestBody.toString());
                runOnUiThread(new Runnable() {
                    int i = 0;
                    @Override
                    public void run() {
                        if (responseBody.getStatus().equals("1")) {
                            ToastUtil.toastLong("修改密码成功");
                            finish();

                        } else if (responseBody.getStatus().equals("0")) {
                            ToastUtil.toastLong("修改密码失败，请重试");

                        }
                    }
                });
            }
        });
    }
}
