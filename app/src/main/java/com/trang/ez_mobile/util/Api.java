package com.trang.ez_mobile.util;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by TraPTH on 2/24/2018.
 */

public interface Api {
    String API_GRATEWAY = "http://gateway.fpts.com.vn/g5g/";//fpts/?s=others_index&c=1&language=0";

    //BASE
    // CHECK IN TIME
    //http://gateway.fpts.com.vn/g5g/fpts/?s=vn_indices
    @GET("fpts/")
    Observable<String> getString(@Query("s") String s);

    //WATCHLIST
    //Chỉ tiêu: http://gateway.fpts.com.vn/g5g/fpts/?s=ezs_report&symbol=
    //Chỉ số: http://gateway.fpts.com.vn/g5g/fpts/?s=ezs_finance&symbol=
    //Thông số các mã: http://gateway.fpts.com.vn/g5g/fpts/?s=quotes2&symbol=fts,fpt,hcm,vnm,
    // Thống kê http://gateway.fpts.com.vn/g5g/fpts/?s=statistic&symbol=
    @GET("fpts/")
    Observable<String> getString(@Query("s") String s, @Query("symbol") String symbol);

    //  MarketData Overview
    //  http://gateway.fpts.com.vn/g5g/fpts/?s=others_index&c=1&language=0
    @GET("fpts/")
    Call<String> getDataMarket(@Query("s") String s, @Query("c") int c, @Query("language") int language);

    @GET("fpts/")
    Observable<String> getDataMarketDetail(@Query("s") String s);

    @GET("fpts/")
    Observable<String> getDataMarketDetailInfo(@Query("s") String s, @Query("c") int c, @Query("type") int type);

    @GET("realtime/")
    Observable<String> getDataMarketChart_OneDay(@Query("s") String s);

    @GET("history/")
    Observable<String> getDataMarketChart(@Query("s") String s);

    //WATCHLIST
    @GET("fpts/")
    Observable<String> getNameCompany(@Query("s") String s, @Query("c") String c, @Query("language") String languge);

    //http://gateway.fpts.com.vn/g5g/fpts?s=news&symbol=fpt&pageindex=1
    //http://gateway.fpts.com.vn/g5g/fpts?s=news2&folder=86&pagesize=1&language=1&symbol=fpt
    //http://gateway.fpts.com.vn/g5g/fpts?s=news_detail&id=
    @GET("fpts/")
    Observable<String> getNewsArticle(@Query("s") String s, @Query("symbol") String symbol, @Query("pageindex") String index);

    @GET("fpts/")
    Observable<String> getFinancialFigures(@Query("s") String s, @Query("symbol") String symbol);

    @GET("realtime/")
    Observable<String> getRealtime(@Query("s") String s);

    //CHART
    @GET("history/")
    Observable<String> getStringHistory(@Query("s") String s);

    //HOME
//    http://gateway.fpts.com.vn/g5g/fpts/?s=news2&folder=82&language=2&pageindex=1&pagesize=5
    @GET("fpts/")
    Observable<String> getNews(@Query("s") String s, @Query("folder") String folder, @Query("language") String language,
                               @Query("pageindex") String pageindex, @Query("pagesize") String pagesize);

    //http://gateway.fpts.com.vn/g5g/fpts/?s=quotes&symbol=fpt,fts,gas,vnm
    @GET("fpts/")
    Observable<String> getWatchlist(@Query("s") String s, @Query("symbol") String symbol);

    //NEWS
    @GET("fpts/")
    Call<String> getStringTinTuc(@Query("s") String s, @Query("language") String language, @Query("folder") String folder,
                                 @Query("symbol") String symbol, @Query("pageindex") String pageindex,
                                 @Query("pagesize") String pagesize);

    @GET("fpts/")
    Call<String> getStringDetailTinTuc(@Query("s") String s, @Query("id") String id);

    //WORLD INDEXES
    @GET("fpts/")
    Call<String> getStringWorldIndeces(@Query("s") String s);

    //Sự kiện
    @GET("fpts/")
    Call<String> getStringEvent(@Query("s") String s, @Query("language") String language);

    //ThongTinChungKhoan
    @GET("fpts/")
    Call<String> getStringTTCK(@Query("s") String s, @Query("symbol") String symbol);

    //CheckTime
    @GET("fpts/")
    Call<String> getStringCheckTime(@Query("s") String s);
}
