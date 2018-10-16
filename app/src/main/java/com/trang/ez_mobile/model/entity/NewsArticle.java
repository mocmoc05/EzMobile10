package com.trang.ez_mobile.model.entity;

/**
 * Created by FIT-thuctap22 on 3/23/2018.
 */

public class NewsArticle {
    private String NewsId;
    private String NewsTitle;
    private String NewsDate;
    private String NewsSize;
    private String NewsSubtile;
    private String NewsContent;
    private String Newslink;

    public NewsArticle() {
    }

    public NewsArticle(String newsId, String newsTitle, String newsDate, String newsSize, String newsSubtile, String newsContent, String newslink) {
        NewsId = newsId;
        NewsTitle = newsTitle;
        NewsDate = newsDate;
        NewsSize = newsSize;
        NewsSubtile = newsSubtile;
        NewsContent = newsContent;
        Newslink = newslink;
    }

    public String getNewsId() {
        return this.NewsId;
    }

    public String getNewsTitle() {
        return this.NewsTitle;
    }

    public String getNewsSubtile() {
        return this.NewsSubtile;
    }

    public String getNewsContent() {
        return this.NewsContent;
    }

    public String getNewsDate() {
        return this.NewsDate;
    }

    public String getNewsSize() {
        return this.NewsSize;
    }

    public String getNewslink() {
        return this.Newslink;
    }

    public void setNewsId(String NewsId) {
        this.NewsId = NewsId;
    }

    public void setNewsTitle(String NewsTitle) {
        this.NewsTitle = NewsTitle;
    }

    public void setNewsSubtile(String NewsSubtile) {
        this.NewsSubtile = NewsSubtile;
    }

    public void setNewsContent(String NewsContent) {
        this.NewsContent = NewsContent;
    }

    public void setNewsDate(String NewsDate) {
        this.NewsDate = NewsDate;
    }

    public void setNewsSize(String NewsSize) {
        this.NewsSize = NewsSize;
    }

    public void setNewslink(String Newslink) {
        this.Newslink = Newslink;
    }


}
