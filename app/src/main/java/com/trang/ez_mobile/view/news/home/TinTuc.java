package com.trang.ez_mobile.view.news.home;


/**
 * Created by TraPTH on 2/22/2018.
 */

public class TinTuc {
    private String stringImg, stringTitle, stringDate, stringId;

    public TinTuc(String stringImg, String stringTitle, String stringDate, String stringId) {
        this.stringImg = stringImg;
        this.stringTitle = stringTitle;
        this.stringDate = stringDate;
        this.stringId = stringId;
    }

    public String getStringImg() {
        return stringImg;
    }

    public void setStringImg(String stringImg) {
        this.stringImg = stringImg;
    }

    public String getStringTitle() {
        return stringTitle;
    }

    public void setStringTitle(String stringTitle) {
        this.stringTitle = stringTitle;
    }

    public String getStringDate() {
        return stringDate;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }
}
