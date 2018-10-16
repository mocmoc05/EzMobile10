package com.trang.ez_mobile.model.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

import com.trang.ez_mobile.model.dao.ICategoryDao;
import com.trang.ez_mobile.model.entity.categories.Category;

/**
 * Created by TraPTH on 1/27/2018.
 */
@Database(entities = {Category.class}, version = 2, exportSchema = false)
public abstract class CategoryDatabase extends RoomDatabase {

    public abstract ICategoryDao dao();

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    };
    public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    };
}


