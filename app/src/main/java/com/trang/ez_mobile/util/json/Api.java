package com.trang.ez_mobile.util.json;

import com.trang.ez_mobile.view.marketOverview.market.model.Market;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    //http://demo3946559.mockable.io/tongquanthitruong
    @GET("tongquanthitruong")
    Observable<List<Market>> getDataMarket();

}
