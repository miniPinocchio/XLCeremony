package com.liuhui.xlceremony.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app
 * user  Pinocchio
 * Date 2015/8/17
 * Email:liu594545591@126.com
 */
public class App extends Application {

    private static Context instance;

    private static String FIRST_OPEN_APP = "first_open_app.pref";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getInstance() {
        return instance;
    }


    /**
     * toast
     */
    public static void toast(@NonNull CharSequence text) {
        Toast.makeText(instance, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * toast
     */
    public static void toast(@StringRes int stringRes) {
        Toast.makeText(instance, stringRes, Toast.LENGTH_SHORT).show();
    }

    /**
     * 是否是手机号
     */
    public static boolean isMobilePhone(String text) {
        String matcher = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))\\d{8}$";
        return text.matches(matcher);
    }
}
