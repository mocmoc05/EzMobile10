package com.trang.ez_mobile.view.watchlist.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.trang.ez_mobile.model.entity.chart.WatchlistData;

import java.util.List;

/**
 * Created by FIT-thuctap22 on 2/1/2018.
 */

@Dao
public interface WatchlistDao {
    @Insert
    void insertav(WatchlistData ent);

    @Query("select * from WatchlistData")
    List<WatchlistData> getAll();

    @Query("select COUNT(*) from WatchlistData where name= :name")
    int check(String name);

    @Query("select COUNT(*) from WatchlistData")
    int count();

    @Query("DELETE from WatchlistData")
    void delete();

    @Query("UPDATE WatchlistData SET name = :name, sort = :sort, `check` = :check WHERE mId = :id")
    void update(String name, int sort, int check, long id);
}