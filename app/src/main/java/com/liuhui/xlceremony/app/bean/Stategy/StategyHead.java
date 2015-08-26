package com.liuhui.xlceremony.app.bean.Stategy;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ziv on Android Studio
 * com.liuhui.xlceremony.app.bean
 * 2015/8/21.
 */
public class StategyHead {
    private String catid;
    private String catname;
    
    public void praseJSON(JSONObject json) throws JSONException {
        catid=json.getString("catid");
        catname=json.getString("catname");
    }

    public String getCatid() {
        return catid;
    }

    public String getCatname() {
        return catname;
    }

    @Override
    public String toString() {
        return "StategyHead{" +
                "catid='" + catid + '\'' +
                ", catname='" + catname + '\'' +
                '}';
    }
}
