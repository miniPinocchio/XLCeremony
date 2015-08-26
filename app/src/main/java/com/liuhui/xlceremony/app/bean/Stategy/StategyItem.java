package com.liuhui.xlceremony.app.bean.Stategy;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Ziv on Android Studio
 * com.liuhui.xlceremony.app.bean
 * 2015/8/21.
 */
public class StategyItem {
    private String id;
    private String title;
    private String fengmian;
    private String userid;
    private String nickname;
    private String avatar;
    private String praisenum;
    private String commentnum;
    private String hints;
    private String share;
    private String keywords;
    private String gifturl;
    private String showgift;
    private String updatetime;
    
    public void praseJSON(JSONObject json) throws JSONException {
        id=json.getString("id");
        title=json.getString("title");
        fengmian=json.getString("userid");
        userid=json.getString("userid");
        nickname=json.getString("nickname");
        avatar=json.getString("avatar");
        praisenum=json.getString("praisenum");
        commentnum=json.getString("commentnum");
        hints=json.getString("hints");
        share=json.getString("share");
        keywords=json.getString("keywords");
        gifturl=json.getString("gifturl");
        showgift=json.getString("showgift");
        updatetime=json.getString("updatetime");
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFengmian() {
        return fengmian;
    }

    public String getUserid() {
        return userid;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPraisenum() {
        return praisenum;
    }

    public String getCommentnum() {
        return commentnum;
    }

    public String getHints() {
        return hints;
    }

    public String getShare() {
        return share;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getGifturl() {
        return gifturl;
    }

    public String getShowgift() {
        return showgift;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    @Override
    public String toString() {
        return "StategyItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", fengmian='" + fengmian + '\'' +
                ", userid='" + userid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", praisenum='" + praisenum + '\'' +
                ", commentnum='" + commentnum + '\'' +
                ", hints='" + hints + '\'' +
                ", share='" + share + '\'' +
                ", keywords='" + keywords + '\'' +
                ", gifturl='" + gifturl + '\'' +
                ", showgift='" + showgift + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
