package com.trang.ez_mobile.view.marketOverview.detail;

import com.trang.ez_mobile.model.entity.DetailMarket;
import com.trang.ez_mobile.model.entity.Market;
import com.trang.ez_mobile.util.ErrorApp;

import java.util.List;

/**
 * Created by TraPTH on 2/23/2018.
 */

public interface IDetail_View {
    void onLoading();

    void onDisplay(DetailMarket detailMarket, int textColor);

    void onDisplayError(ErrorApp error);

    void onUpdateTitle(String title);

    interface IDetailPrice_View {
        void onError(ErrorApp error);

        void onDisplay(List<Market> marketList);
    }
}
