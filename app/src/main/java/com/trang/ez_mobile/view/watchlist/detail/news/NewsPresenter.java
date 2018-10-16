package com.trang.ez_mobile.view.watchlist.detail.news;

import com.trang.ez_mobile.model.entity.NewsArticle;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;

/**
 * Created by FIT-thuctap22 on 3/23/2018.
 */

public class NewsPresenter {
    INewsView iNewsView;
    String key;
    Api api;
    boolean isRequesting = false;
    List<NewsArticle> articleList = new ArrayList<>();

    public NewsPresenter(INewsView iNewsView, String key) {
        this.iNewsView = iNewsView;
        this.key = key;
        LoadData();
    }

    private void LoadData() {
        if (isRequesting) {
            return;
        }
        if (!Utils.isNetworkAvailable()) {
            return;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            LoadData();
            return;
        }
        isRequesting = true;
        articleList = new ArrayList<>();
        api.getNewsArticle("news", key, "1")
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    String[] lines = s.split("@");
                    for (int i = 0; i < lines.length - 1; i++) {
                        String[] parts = lines[i].split("#");
                        if (parts.length > 2) {
                            NewsArticle article = new NewsArticle();
                            try {
                                article.setNewsId(parts[0]);
                            } catch (Exception e) {
                                article.setNewsId("");
                            }
                            try {
                                article.setNewsTitle(parts[1]);
                            } catch (Exception e) {
                                article.setNewsTitle("");
                            }
                            try {
                                article.setNewsDate(parts[2].substring(0, parts[2].length() - 6));
                            } catch (Exception e) {
                                article.setNewsTitle("");
                            }
                            try {
                                article.setNewsSize(parts[3]);
                            } catch (Exception e) {
                                article.setNewsSize(parts[3]);
                            }
                            try {
                                article.setNewsSubtile(parts[4]);
                            } catch (Exception e) {
                                article.setNewsSubtile("");
                            }
                            try {
                                article.setNewslink(parts[5]);
                            } catch (Exception e) {
                                article.setNewslink("");
                            }
                            articleList.add(article);
                        }
                    }
                    iNewsView.Display(articleList);
                }, throwable -> {
                    throwable.printStackTrace();
                }, () -> {
                    isRequesting = false;
                });

    }
}
