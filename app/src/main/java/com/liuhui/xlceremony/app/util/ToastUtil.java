package com.liuhui.xlceremony.app.util;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.liuhui.xlceremony.app.App;

/**
 * Created from "com.liuhui.xlceremony.app.util".
 * User ：${Yan}[ZY] on 2015/8/18 0018 19:14
 * Email ：530412159@qq.com
 */
public class ToastUtil {

	private static Handler handler = new Handler(Looper.getMainLooper());

	private static Toast toast;
	
	private static Context context;

	public ToastUtil() {
		
	}
	static {
		context=new App().getInstance();
	}

	static void toast(final Context act, final int msg, final int len) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				handler.post(new Runnable() {
					@Override
					public void run() {
						synchronized (ToastUtil.class) {
							if (toast != null) {
								toast.cancel();
								toast.setText(msg);
								toast.setDuration(len);
							} else {
								toast = Toast.makeText(act, msg, len);
							}
							toast.show();
						}
					}
				});
			}
		}).start();
	}

	public static void toast(final Context act, final String msg, final int len) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				handler.post(new Runnable() {
					@Override
					public void run() {
						synchronized (ToastUtil.class) {
							if (toast != null) {
								toast.cancel();
								toast.setText(msg);
								toast.setDuration(len);
							} else {
								toast = Toast.makeText(act, msg, len);
							}
							toast.show();
						}
					}
				});
			}
		}).start();
	}

	public static void toastShort( final String msg) {
		toast(context, msg, Toast.LENGTH_SHORT);
	}

	public static void toastShort( final int msg) {
		toast(context, msg, Toast.LENGTH_SHORT);
	}

	public static void toastLong( final String msg) {
		toast(context, msg, Toast.LENGTH_LONG);
	}

	public static void toastLong( final int msg) {
		toast(context, msg, Toast.LENGTH_LONG);
	}
	

	public static void cancelCurrentToast() {
		if (toast != null) {
			toast.cancel();
		}
	}
}

