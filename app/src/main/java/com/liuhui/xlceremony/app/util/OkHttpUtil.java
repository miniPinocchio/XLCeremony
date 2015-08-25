package com.liuhui.xlceremony.app.util;

import android.os.AsyncTask;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.util
 * user  Pinocchio
 * Date 2015/8/17
 * Email:liu594545591@126.com
 */
public class OkHttpUtil {
    private static final OkHttpClient mOkHttpClient = new OkHttpClient();

    private OkHttpUtil() {}

    static {
        mOkHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
    }

    /**
     * 开启异步线程访问网络
     */
    public static void enqueue(Request request, Callback responseCallback) {
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }
    

    /**
     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
     */
    public static void enqueue(Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Response arg0) throws IOException {}

            @Override
            public void onFailure(Request arg0, IOException arg1) {}

        });
    }
}
