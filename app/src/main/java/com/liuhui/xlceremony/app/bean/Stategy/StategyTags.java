package com.liuhui.xlceremony.app.bean.Stategy;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ziv on Android Studio
 * com.liuhui.xlceremony.app.bean
 * 2015/8/21.
 */
public class StategyTags {
    private String id;
    private String name;
    private String letter;
    private String listorder;
    
    public void praseJSON(JSONObject json) throws JSONException {
        id=json.getString("id");
        name=json.getString("name");
        letter=json.getString("letter");
        listorder=json.getString("listorder");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLetter() {
        return letter;
    }

    public String getListorder() {
        return listorder;
    }

    @Override
    public String toString() {
        return "StategyTags{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", letter='" + letter + '\'' +
                ", listorder='" + listorder + '\'' +
                '}';
    }
}
