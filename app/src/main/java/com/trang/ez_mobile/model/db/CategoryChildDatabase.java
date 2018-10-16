package com.trang.ez_mobile.model.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

import com.trang.ez_mobile.model.dao.ICategoryChildDao;
import com.trang.ez_mobile.model.entity.categories.CategoryChild;

/**
 * Created by TraPTH on 2/1/2018.
 */
@Database(entities = {CategoryChild.class}, version = 2, exportSchema = false)
public abstract class CategoryChildDatabase extends RoomDatabase {

    public abstract ICategoryChildDao dao();


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
