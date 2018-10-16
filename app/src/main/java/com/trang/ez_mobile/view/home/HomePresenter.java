package com.trang.ez_mobile.view.home;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.model.entity.CodeStockWatchList;
import com.trang.ez_mobile.model.entity.NewsArticle;
import com.trang.ez_mobile.model.entity.StockMarket;
import com.trang.ez_mobile.model.entity.WorldIndices;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.view.home.custormHome.BigGroup;
import com.trang.ez_mobile.view.home.custormHome.ItemHomeChild;
import com.trang.ez_mobile.view.home.custormHome.ItemNewsEvents;
import com.trang.ez_mobile.view.home.custormHome.ItemNumber;
import com.trang.ez_mobile.view.home.custormHome.ItemHeaderNumber;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;
import static com.trang.ez_mobile.util.Define.HOME_SHARED_PREFERENCES;
import static com.trang.ez_mobile.util.Define.HOME_SHARED_PREFERENCES_NEWS;
import static com.trang.ez_mobile.util.Define.HOME_SHARED_PREFERENCES_WATCHLIST;
import static com.trang.ez_mobile.util.Define.HOME_SHARED_PREFERENCES_WATCHLIST_LIST;
import static com.trang.ez_mobile.util.Define.HOME_SHARED_PREFERENCES_WORLDINDEXES_LIST;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_BANG_GIA_PHAI_SINH;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_INDEXES;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_NEWS;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_WATCHLIST;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_WORLD_INDEXES;

public class HomePresenter {
    private final int TIME_DELAY = 500;
    IHomeView view;
    Activity activity;

    SparseArray<BigGroup> sparseArray;
    List<StockMarket> indexesList = new ArrayList<>();
    List<NewsArticle> newsArticleList = new ArrayList<>();
    List<CodeStockWatchList> watchListList = new ArrayList<>();
    List<WorldIndices> worldIndexList = new ArrayList<>();

    private Api api;
    private boolean isRequesting_indexes = false;
    private boolean isRequesting_news = false;
    private boolean isRequesting_watchlist = false;
    private boolean isRequesting_worldIndex = false;

//    Handler handler_watchlist = new Handler();
//    Handler handler_indexes = new Handler();

    public HomePresenter(IHomeView view, Activity activity) {
        this.view = view;
        this.activity = activity;
        view.onLoading();
        sparseArray = new SparseArray<>();

        new Handler().postDelayed(() -> {
            LoadviewDataHome task = new LoadviewDataHome();
            task.execute();
        }, TIME_DELAY);
    }

    public void onReload() {
        new Handler().postDelayed(() -> {
            sparseArray = new SparseArray<>();
            LoadviewDataHome task = new LoadviewDataHome();
            task.execute();
        }, TIME_DELAY);
    }

    private class LoadviewDataHome extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.w("LoadviewDataHome", "onPreExecute: ");
        }

        @Override
        protected String doInBackground(String... params) {
            Log.w("LoadviewDataHome", "doInBackground: ");
            LoadIndexes();
            LoadDataNews();
            LoadDataWorldIndex();
            LoadDataWachlist();
            activity.runOnUiThread(() -> new Handler().postDelayed(() -> addData(), TIME_DELAY));
//            addData();
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.w("LoadviewDataHome", "onPostExecute: ");
        }
    }

//    public void LoadWatchlist() {
//        handler_watchlist.post(runable_watchlist);
//    }
//
//    public void LoadDataIndexes() {
//        handler_indexes.post(runnable_indexes);
//    }

//    int count1 = 0;
//    Runnable runable_watchlist = new Runnable() {
//        @Override
//        public void run() {
//            LoadDataWachlist();
//            if (count1 < 1) {
//                handler_watchlist.postDelayed(runable_watchlist, TIME_DELAY);
//                count1++;
//            }
//            boolean check = checkInTime();
//            if (!check) {
//                handler_watchlist.postDelayed(runable_watchlist, TIME_DELAY);
//            }
//        }
//    };

//    int count2 = 0;
//    Runnable runnable_indexes = new Runnable() {
//        @Override
//        public void run() {
//            LoadIndexes();
//            if (count2 < 1) {
//                handler_indexes.postDelayed(runnable_indexes, TIME_DELAY);
//                count2++;
//            } else if (!checkInTime()) {
//                handler_indexes.postDelayed(runnable_indexes, TIME_DELAY);
//            }
//        }
//    };

    private void addData() {
//        // PHẦN INDEXES
        sparseArray.append(sparseArray.size(), new BigGroup(HOME_TYPE_INDEXES, "", new SparseArray<>()));
        //WATCHLIST
        SparseArray<ItemHomeChild> temp1 = new SparseArray<>();
        temp1.append(temp1.size(), new ItemHeaderNumber(
                App.getInstance().getResources().getString(R.string.indexes),
                App.getInstance().getResources().getString(R.string.last),
                App.getInstance().getResources().getString(R.string.change) + "◥",
                App.getInstance().getResources().getString(R.string.change_percent) + " ◥",
                App.getInstance().getResources().getString(R.string.volumn) + "◥",
                App.getInstance().getResources().getString(R.string.value_bil) + "◥",
                HOME_TYPE_WATCHLIST));
        for (int i = 0; i < watchListList.size(); i++) {
            temp1.append(temp1.size(), new ItemNumber(watchListList.get(i).getCode(), watchListList.get(i).getMatchPrice(),
                    watchListList.get(i).getChangePrice(), "", watchListList.get(i).getTotalQuantity(),
                    "", watchListList.get(i).getUpDown(), HOME_TYPE_WATCHLIST, null, null, watchListList.get(i), null));
        }
        sparseArray.append(sparseArray.size(), new BigGroup(HOME_TYPE_WATCHLIST, App.getInstance().getResources().getString(R.string.watchlist), temp1));

        // NEWS
        SparseArray<ItemHomeChild> temp_news = new SparseArray<>();
        for (int i = 0; i < newsArticleList.size(); i++) {
            temp_news.append(temp_news.size(),
                    new ItemNewsEvents(newsArticleList.get(i).getNewsTitle(), newsArticleList.get(i).getNewsDate(), "",
                            HOME_TYPE_NEWS, newsArticleList.get(i).getNewsId(), newsArticleList.get(i).getNewslink()));
        }
        sparseArray.append(sparseArray.size(), new BigGroup(HOME_TYPE_NEWS, App.getInstance().getResources().getString(R.string.news), temp_news));

        //        //PHẦN WORLD INDEXES
        SparseArray<ItemHomeChild> temp_worldIndex = new SparseArray<>();
        temp_worldIndex.append(temp_worldIndex.size(), new ItemHeaderNumber(
                App.getInstance().getResources().getString(R.string.indexes),
                App.getInstance().getResources().getString(R.string.last),
                App.getInstance().getResources().getString(R.string.change) + "◥",
                App.getInstance().getResources().getString(R.string.change_percent) + " ◥",
                App.getInstance().getResources().getString(R.string.volumn) + "◥",
                App.getInstance().getResources().getString(R.string.value_bil) + "◥",
                HOME_TYPE_WORLD_INDEXES));
        for (int i = 0; i < worldIndexList.size(); i++) {
            temp_worldIndex.append(temp_worldIndex.size(), new ItemNumber(worldIndexList.get(i).getTitleWord().toUpperCase(), worldIndexList.get(i).getLastWord(),
                    worldIndexList.get(i).getChangWord(), worldIndexList.get(i).getChangRatio(), "", "",
                    "", HOME_TYPE_WORLD_INDEXES,
                    null, worldIndexList.get(i), null, null));
        }
        sparseArray.append(sparseArray.size(), new BigGroup(HOME_TYPE_WORLD_INDEXES, App.getInstance().getResources().getString(R.string.world_index), temp_worldIndex));
        view.onDisplay(sparseArray);
    }

    private void LoadIndexes() {
        if (isRequesting_indexes) {
            return;
        }
        if (!Utils.isNetworkAvailable()) {
            //
            getDataFromSharedPreferences(HOME_TYPE_INDEXES);
            return;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            LoadIndexes();
            return;
        }
        isRequesting_indexes = true;
        indexesList = new ArrayList<>();
        api.getString("vn_indices").subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    try {
                        String[] lines = s.split("@");
                        for (int i = 0; i < lines.length - 1; i++) {
                            StockMarket stockMarket = new StockMarket();
                            String[] parts = lines[i + 1].split("#");
                            if (parts.length > 6) {
                                stockMarket.setMarketName(parts[0]);
                                stockMarket.setMarketPrice(parts[1]);
                                stockMarket.setMarketColorCode(parts[2]);
                                stockMarket.setMarketValueChange(parts[3] + " ");
                                stockMarket.setMarketValueChangeRatio(" " + parts[4]);
                                stockMarket.setMarketToTalVolumn(parts[5]);
                                stockMarket.setMarketToTalValue(parts[6].trim().replace(" bil", ""));
                                stockMarket.setIsMarketData(true);
                            }
                            indexesList.add(stockMarket);
                        }
                        saveDataToSharedPreferences(HOME_TYPE_WORLD_INDEXES);
                    } catch (Exception e) {
                    }
                }, throwable -> throwable.printStackTrace(), () -> isRequesting_indexes = false);
    }

    public void LoadDataNews() {
        if (isRequesting_news) {
            return;
        }
        if (!Utils.isNetworkAvailable()) {
            getDataFromSharedPreferences(HOME_TYPE_NEWS);
            return;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            LoadDataNews();
            return;
        }
        isRequesting_news = true;
        newsArticleList = new ArrayList<>();
//        SharedPreferences preferences = App.getInstance().getSharedPreferences(SHARED_PREFRENCES_LANGUAGE, Context.MODE_PRIVATE);
//        String language = preferences.getInt(SHARED_PREFRENCES_LANGUAGE, LANGUAGE_EN) + "";
        //link news chỉ có tiếng Việt
        api.getNews("news2", "82", "1", "1", "5")
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    try {
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
                                newsArticleList.add(article);
                            }
                        }
                        saveDataToSharedPreferences(HOME_TYPE_NEWS);
                    } catch (NullPointerException e) {
                        getDataFromSharedPreferences(HOME_TYPE_NEWS);
                    }
                }, throwable -> {
                    getDataFromSharedPreferences(HOME_TYPE_NEWS);
                }, () -> isRequesting_news = false);
    }

    private void LoadDataWachlist() {
        if (isRequesting_watchlist) {
            return;
        }
        if (!Utils.isNetworkAvailable()) {
            getDataFromSharedPreferences(HOME_TYPE_WATCHLIST);
            return;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            LoadDataWachlist();
            return;
        }
        isRequesting_watchlist = true;
        watchListList = new ArrayList<>();
        SharedPreferences preferences = App.getInstance().getSharedPreferences(HOME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String watchlist = preferences.getString(HOME_SHARED_PREFERENCES_WATCHLIST,
                "fpt,fts,gas,vnm,cee,aaa,amd,anv,bhn,bcg,bmp,brc,cll,clw,cig,cdo,dhm,dmc,dlg,dat,flc,fmc,fit,ibc,ice,asm,stb,scr,hdb,mbb,flc,ctg,idi,hag,ssi,vcb,hbc,kbc,bid,hpg,hqc,dxg,lvhg,vic");
        api.getWatchlist("quotes", watchlist)
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    try {
                        String line[] = s.split("@");
                        for (int i = 0; i < line.length; i++) {
                            String[] part = line[i].split("#");
                            CodeStockWatchList codeStockWatchList = new CodeStockWatchList();
                            try {
                                codeStockWatchList.setCode(part[0]);
                                String str = part[0];
                            } catch (Exception e) {
                                codeStockWatchList.setCode("");
                                e.printStackTrace();
                            }
                            try {
                                codeStockWatchList.setUpDown(part[1]);
                            } catch (Exception e) {
                                codeStockWatchList.setUpDown("");
                                e.printStackTrace();
                            }
                            try {
                                codeStockWatchList.setMatchPrice(String.valueOf(part[2]));
                            } catch (Exception e) {
                                codeStockWatchList.setMatchPrice("");
                                e.printStackTrace();
                            }
                            try {
                                codeStockWatchList.setChangePrice(String.valueOf(part[3]));
                            } catch (Exception e) {
                                codeStockWatchList.setChangePrice("");
                                e.printStackTrace();
                            }
                            try {
                                codeStockWatchList.setTotalQuantity(String.valueOf(part[4]));
                            } catch (Exception e) {
                                codeStockWatchList.setTotalQuantity("");
                                e.printStackTrace();
                            }
                            try {
                                codeStockWatchList.setCenterNo(String.valueOf(part[5]));
                            } catch (Exception e) {
                                codeStockWatchList.setCenterNo("");
                                e.printStackTrace();
                            }
                            try {
                                codeStockWatchList.setCeiling(String.valueOf(part[6]));
                            } catch (Exception e) {
                                codeStockWatchList.setCeiling("");
                                e.printStackTrace();
                            }
                            try {
                                codeStockWatchList.setFloor(String.valueOf(part[7]));
                            } catch (Exception e) {
                                codeStockWatchList.setFloor("");
                                e.printStackTrace();
                            }
                            try {
                                codeStockWatchList.setRefPrice(String.valueOf(part[8]));
                            } catch (Exception e) {
                                codeStockWatchList.setRefPrice("");
                                e.printStackTrace();
                            }
                            watchListList.add(codeStockWatchList);
                        }
                        saveDataToSharedPreferences(HOME_TYPE_WATCHLIST);
                    } catch (Exception e) {
                    }
                }, throwable -> {
                }, () -> isRequesting_watchlist = false);
    }

    public void LoadDataWorldIndex() {
        if (isRequesting_worldIndex) {
            return;
        }
        if (!Utils.isNetworkAvailable()) {
            getDataFromSharedPreferences(HOME_TYPE_WATCHLIST);
            return;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            LoadDataWorldIndex();
            return;
        }
        isRequesting_worldIndex = true;
        worldIndexList = new ArrayList<>();
        api.getString("world_indices")
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    try {
                        String[] lines = s.split("@");

                        for (int i = 0; i < lines.length; i++) {
                            try {
                                WorldIndices worldIndices = new WorldIndices();
                                String[] item = lines[i].split("#");
                                worldIndices.setTitleWord(item[0]);
                                worldIndices.setLastWord(item[2]);
                                worldIndices.setChangWord(item[3]);
                                worldIndices.setChangRatio(item[4]);
                                worldIndexList.add(worldIndices);
                            } catch (Exception e) {
                            }
                        }
                        saveDataToSharedPreferences(HOME_TYPE_WORLD_INDEXES);
                    } catch (Exception e) {
                        getDataFromSharedPreferences(HOME_TYPE_WORLD_INDEXES);
                    }
                }, throwable -> {
                    getDataFromSharedPreferences(HOME_TYPE_WORLD_INDEXES);
                }, () -> isRequesting_worldIndex = false);
    }

    private void getDataFromSharedPreferences(int type) {
        SharedPreferences preferences = App.getInstance().getSharedPreferences(HOME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        switch (type) {
            case HOME_TYPE_NEWS:
                String str_news = preferences.getString(HOME_SHARED_PREFERENCES_NEWS, "");
                newsArticleList = new ArrayList<>();
                Type typeToken = new TypeToken<List<NewsArticle>>() {
                }.getType();
                newsArticleList = gson.fromJson(str_news, typeToken);
                break;
            case HOME_TYPE_INDEXES:
                //SAVE OR NOT
                break;
            case HOME_TYPE_WATCHLIST:
                String str_watchlist = preferences.getString(HOME_SHARED_PREFERENCES_WATCHLIST_LIST, "");
                Type typeToken1 = new TypeToken<List<CodeStockWatchList>>() {
                }.getType();
                watchListList = gson.fromJson(str_watchlist, typeToken1);
                break;
            case HOME_TYPE_WORLD_INDEXES:
                String str_inedexes = preferences.getString(HOME_SHARED_PREFERENCES_WORLDINDEXES_LIST, "");
                worldIndexList = new ArrayList<>();
                Type typeToken2 = new TypeToken<List<CodeStockWatchList>>() {
                }.getType();
                worldIndexList = gson.fromJson(str_inedexes, typeToken2);
                break;
            default:
                break;
        }
    }

    private void saveDataToSharedPreferences(int type) {
        SharedPreferences preferences = App.getInstance().getSharedPreferences(HOME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        switch (type) {
            case HOME_TYPE_NEWS:
                String str_news = gson.toJson(newsArticleList);
                editor.putString(HOME_SHARED_PREFERENCES_NEWS, str_news);
                break;
            case HOME_TYPE_INDEXES:
                //SAVE OR NOT
                break;
            case HOME_TYPE_WATCHLIST:
                String str_watchlist = gson.toJson(watchListList);
                editor.putString(HOME_SHARED_PREFERENCES_WATCHLIST_LIST, str_watchlist);
                break;
            case HOME_TYPE_WORLD_INDEXES:
                String str_inedexes = gson.toJson(worldIndexList);
                editor.putString(HOME_SHARED_PREFERENCES_WORLDINDEXES_LIST, str_inedexes);
                break;
            default:
                break;
        }
        editor.commit();
        editor.apply();
    }

    public void onDestroy() {
//        if (handler_indexes != null) {
//            handler_indexes.removeCallbacks(runnable_indexes);
//        }
//        if (handler_watchlist != null) {
//            handler_watchlist.removeCallbacks(runable_watchlist);
//        }
    }
}
