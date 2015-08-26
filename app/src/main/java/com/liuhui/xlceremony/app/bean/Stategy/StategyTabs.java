package com.liuhui.xlceremony.app.bean.Stategy;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ziv on Android Studio
 * com.liuhui.xlceremony.app.bean
 * 2015/8/21.
 */
public class StategyTabs {
    private String typeid;
    private String typename;

    public void praseJSON(JSONObject json) throws JSONException {
        typeid=json.getString("catid");
        typename=json.getString("catname");
    }

    public String getCatid() {
        return typeid;
    }

    public String getCatname() {
        return typename;
    }

    @Override
    public String toString() {
        return "StategyHead{" +
                "catid='" + typeid + '\'' +
                ", catname='" + typename + '\'' +
                '}';
    }
}
