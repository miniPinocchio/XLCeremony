package com.liuhui.xlceremony.app.bean.Stategy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ziv on Android Studio
 * com.liuhui.xlceremony.app.bean
 * 2015/8/21.
 */
public class Stategy {
    private List<StategyItem> idealist;
    private List<StategyHead> catlist;
    private List<StategyTabs> typelist;
    private List<StategyTags> tags;
    private String limit;
    
    public void praseJSON(JSONObject json) throws JSONException {
        JSONArray idea = json.getJSONArray("idealist");
        idealist=new LinkedList<StategyItem>();
        int ideaLength = idea.length();
        for (int i = 0; i < ideaLength; i++) {
            StategyItem stategyItem = new StategyItem();
            stategyItem.praseJSON(idea.getJSONObject(i));
            idealist.add(stategyItem);
        }
        JSONArray cat = json.getJSONArray("catlist");
        catlist=new LinkedList<StategyHead>();
        int catLength = cat.length();
        for (int i = 0; i < catLength; i++) {
            StategyHead stategyHead = new StategyHead();
            stategyHead.praseJSON(cat.getJSONObject(i));
            catlist.add(stategyHead);
        }
        JSONArray type = json.getJSONArray("typelist");
        typelist=new LinkedList<StategyTabs>();
        int typeLength = type.length();
        for (int i = 0; i < typeLength; i++) {
            StategyTabs stategyTabs = new StategyTabs();
            stategyTabs.praseJSON(type.getJSONObject(i));
            typelist.add(stategyTabs);
        }
        JSONArray tag = json.getJSONArray("tags");
        tags=new LinkedList<StategyTags>();
        int tagLength = tag.length();
        for (int i = 0; i < tagLength; i++) {
            StategyTags stategyTags = new StategyTags();
            stategyTags.praseJSON(tag.getJSONObject(i));
            tags.add(stategyTags);
        }
        limit=json.getString("limit");
    }

    public List<StategyItem> getIdealist() {
        return idealist;
    }

    public List<StategyHead> getCatlist() {
        return catlist;
    }

    public List<StategyTabs> getTypelist() {
        return typelist;
    }

    public List<StategyTags> getTags() {
        return tags;
    }

    public String getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Stategy{" +
                "idealist=" + idealist +
                ", catlist=" + catlist +
                ", typelist=" + typelist +
                ", tags=" + tags +
                ", limit='" + limit + '\'' +
                '}';
    }
}
