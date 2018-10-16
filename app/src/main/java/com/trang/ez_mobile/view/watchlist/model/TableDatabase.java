package com.trang.ez_mobile.view.watchlist.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

import com.trang.ez_mobile.model.entity.chart.WatchlistData;


/**
 * Created by FIT-thuctap22 on 2/1/2018.
 */

@Database(entities = {WatchlistData.class}, version = 1, exportSchema = false)
public abstract class TableDatabase extends RoomDatabase {

    public abstract WatchlistDao userDao();

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    };
}