package com.trang.ez_mobile.view.watchlist.detail.foreignOwnership;

import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.view.watchlist.model.Stock;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;

/**
 * Created by FIT-thuctap22 on 2/6/2018.
 */

public class ForeignOwnershipPresenter {

    IForeignOwnershipView v;

    private String symbol;


    public ForeignOwnershipPresenter(  IForeignOwnershipView v, String symbol) {
        this.v = v;
        this.symbol = symbol;

        LoadData();
    }

    private void LoadData() {
        Api api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);

        api.getString("statistic", symbol).subscribeOn(Schedulers.io())
                .map(s -> s).observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
            String repeace = s.replaceAll("\\^", "#");
            String[] parts = repeace.split("#");
            Stock res = new Stock();

            try {
                res.setLastPrice(parts[25]);
            } catch (Exception e) {
                res.setLastPrice("");
            }

            try {
                res.setChange(parts[3]);
            } catch (Exception e) {
                res.setChange("");
            }

            try {
                res.setChangePer(parts[5]);
            } catch (Exception e) {
                res.setChangePer("");
            }
            try {
                res.setVolume(parts[13]);
            } catch (Exception e) {
                res.setVolume("");
            }
            try {
                res.setHigh(parts[11]);
            } catch (Exception e) {
                res.setHigh("");
            }

            try {
                res.setLow(parts[9]);
            } catch (Exception e) {
                res.setLow("");
            }

            try {
                res.setForeignBuy(parts[19]);
            } catch (Exception e) {
                res.setForeignBuy("0");
            }

            try {
                res.setForeignSell(parts[21]);
            } catch (Exception e) {
                res.setForeignSell("");
            }

            try {
                res.setRef(parts[7]);
            } catch (Exception e) {
                res.setRef("");
            }
            try {
                res.setCeil(parts[57]);
            } catch (Exception e) {
                res.setCeil("");
            }

            try {
                res.setFloor(parts[59]);
            } catch (Exception e) {
                res.setFloor("");
            }

            try {
                //res.setTotalMatchingVol(parts[39]);
                res.setTotalMatchingVol(parts[13]);
            } catch (Exception e) {
                res.setTotalMatchingVol("0");
            }

            try {
                res.setTotalMatchingVal(parts[41]);
            } catch (Exception e) {
                res.setTotalMatchingVal("0");
            }

            try {
                res.setTotalPutthroughVol(parts[35]);
            } catch (Exception e) {
                res.setTotalPutthroughVol("0");
            }

            try {
                res.setTotalPutthroughVal(parts[37]);
            } catch (Exception e) {
                res.setTotalPutthroughVal("0");
            }

            try {
                res.setRoom(parts[45]);
            } catch (Exception e) {
                res.setRoom("0");
            }

            try {
                res.setCurrentRoom(parts[47]);
            } catch (Exception e) {
                res.setCurrentRoom("0");
            }

            try {
                res.setRemainRoom(parts[49]);
            } catch (Exception e) {
                res.setRemainRoom("0");
            }

            try {
                res.setRatios(parts[51]);
            } catch (Exception e) {
                res.setRatios("0");
            }

            try {
                res.setDateUpdate(parts[62]);
            } catch (Exception e) {
                res.setDateUpdate("0");
            }

            v.display(res);
        }, throwable -> {
        }, () -> {
        });

    }
}
