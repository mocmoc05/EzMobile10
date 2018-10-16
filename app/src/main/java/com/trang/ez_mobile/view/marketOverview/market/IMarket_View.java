package com.trang.ez_mobile.view.marketOverview.market;

import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.view.marketOverview.market.model.Market;

import java.util.List;

/**
 * Created by TraPTH on 2/21/2018.
 */

public interface IMarket_View {

    void onDisplay(List<Market> marketList);

    void onDisplayReplaceFragment(String marketCode);

    void onDisplayError(ErrorApp error);

    interface IOnclickListener {
        void onItemClick(String marketName);

        void onItemClick(String marketName, boolean isChecked);
    }
}
