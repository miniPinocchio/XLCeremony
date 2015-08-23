package com.liuhui.xlceremony.app.bean;

import java.util.List;

/**
 * Created by Administrator on 2015/8/22.
 */
public class Photo {
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List<SubPhoto> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<SubPhoto> photoList) {
        this.photoList = photoList;
    }

    private int day;
    private int year;
    private int month;

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    private int clickCount;

    private List<SubPhoto> photoList;


}
