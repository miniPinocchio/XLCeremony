package com.liuhui.xlceremony.app.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.liuhui.xlceremony.app.App;

/**
 * Created from "com.liuhui.xlceremony.app.util".
 * User ：${Yan}[ZY] on 2015/8/18 0018 19:14
 * Email ：530412159@qq.com
 */
public class ToastUtil {

	private static Context context;
	
	public ToastUtil() {

	}

	static {
		context = new App().getInstance();
	}

	static void toast(Context act, int msg, int len) {


		Toast.makeText(act, Integer.toString(msg), len).show();

	}


	public static void toast(Context act, String msg, int len) {

		Toast.makeText(act, msg, len).show();

	}


	public static void toastShort(final String msg) {
		toast(context, msg, Toast.LENGTH_SHORT);
	}

	public static void toastShort(final int msg) {
		toast(context, msg, Toast.LENGTH_SHORT);
	}

	public static void toastLong(String msg) {
		toast(context, msg, Toast.LENGTH_LONG);

	}

	public static void toastLong(final int msg) {
		toast(context, msg, Toast.LENGTH_LONG);
	}


};

