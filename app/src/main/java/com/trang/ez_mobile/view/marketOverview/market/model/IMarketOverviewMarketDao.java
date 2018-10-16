package com.trang.ez_mobile.view.marketOverview.market.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by FIT-thuctap22 on 3/20/2018.
 */
@Dao
public interface IMarketOverviewMarketDao {
    @Query("SELECT * FROM MarketData")
    List<MarketData> getAll();

    @Query("SELECT * FROM MarketData WHERE isSave = 1")
    List<MarketData> getAllCheck();

    @Query("UPDATE MarketData SET isSave = :isSave  WHERE marketName = :marketName")
    void update(String marketName, boolean isSave);

    @Query("SELECT isSave FROM MarketData WHERE marketName =:marketName")
        int getMarketCheck(String marketName);

    @Query("SELECT * FROM MarketData WHERE marketName = :marketName AND isSave = 1 LIMIT 1")
    MarketData getMarket(String marketName);

    @Insert
    void insert(MarketData marketData);
}
