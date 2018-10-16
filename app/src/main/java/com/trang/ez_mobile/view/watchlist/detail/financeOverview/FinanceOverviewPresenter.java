package com.trang.ez_mobile.view.watchlist.detail.financeOverview;

import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.ColorTr;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.view.watchlist.detail.financialFigures.Finance;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;

/**
 * Created by FIT-thuctap22 on 2/7/2018.
 */

public class FinanceOverviewPresenter {
    IFinanceOverviewView v;
    private String symbol;

    public FinanceOverviewPresenter(IFinanceOverviewView v, String symbol) {
        this.v = v;
        this.symbol = symbol;

        LoadData();
    }


    private void LoadData() {
        Api api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
        final List<Finance> data = new ArrayList<>();
        api.getString("ezs_finance", symbol).subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    String[] line = s.split("@");

                    for (int i = 0; i < line.length; i++) {
                        String[] part = line[i].split("\\|");
                        Finance finance = new Finance();
                        try {
                            finance.setKeyFinace(part[0]);
                        } catch (Exception e) {
                            finance.setKeyFinace("");
                        }

                        String value;
                        try {
                            value = ColorTr.formatNumber(part[1]);

                        } catch (Exception e) {
                            value = "";
                        }

                        finance.setValueFinace(value);
                        data.add(finance);
                    }
                    v.display(data);
                }, throwable -> {
                }, () -> {
                });
    }
}
