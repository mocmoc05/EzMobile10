package com.trang.ez_mobile.view.marketOverview.market;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.view.marketOverview.market.model.MarketData;
import com.trang.ez_mobile.view.marketOverview.market.model.MarketDatabase;

import static android.arch.persistence.room.Room.databaseBuilder;
import static com.trang.ez_mobile.util.Define.CATEGORY_DB;
import static com.trang.ez_mobile.view.marketOverview.market.model.MarketDatabase.MIGRATION_2_3;

/**
 * Created by FIT-thuctap22 on 3/21/2018.
 */

public class MarketAdapterPresenter {
    MarketDatabase marketDatabase;

    public MarketAdapterPresenter() {
        marketDatabase = databaseBuilder(App.getInstance(), MarketDatabase.class, CATEGORY_DB)
                .addMigrations(MIGRATION_2_3)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();


    }

    public boolean getChecked(String marketName) {

        MarketData marketData = marketDatabase.dao().getMarket(marketName);
        if (marketData == null) {
            return true;
        } else return marketData.isSave();
    }
}
