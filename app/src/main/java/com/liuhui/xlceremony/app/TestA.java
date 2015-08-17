package com.liuhui.xlceremony.app;

import android.util.Log;

import com.liuhui.xlceremony.app.util.LogUtil;

/**
 * Created from "com.liuhui.xlceremony.app".
 * User ：${Yan}[ZY] on 2015/8/17 0017 17:12
 * Email ：530412159@qq.com
 */
public class TestA {
	void aa() {
		Log.d("TestA", "hehe");
		if (BuildConfig.DEBUG) Log.d("TestA", "zz");
	}
}
