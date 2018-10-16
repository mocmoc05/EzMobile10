package com.trang.ez_mobile.model.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import com.trang.ez_mobile.model.dao.ICategoryChildDao;
import com.trang.ez_mobile.model.dao.ICategoryChildDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class CategoryChildDatabase_Impl extends CategoryChildDatabase {
  private volatile ICategoryChildDao _iCategoryChildDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CategoryChild` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `name_en` TEXT, `categoryId` INTEGER NOT NULL, `isFavorite` INTEGER NOT NULL, `typeFragment` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"b0db381e6149f5d9ad07049745030218\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `CategoryChild`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCategoryChild = new HashMap<String, TableInfo.Column>(6);
        _columnsCategoryChild.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsCategoryChild.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsCategoryChild.put("name_en", new TableInfo.Column("name_en", "TEXT", false, 0));
        _columnsCategoryChild.put("categoryId", new TableInfo.Column("categoryId", "INTEGER", true, 0));
        _columnsCategoryChild.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", true, 0));
        _columnsCategoryChild.put("typeFragment", new TableInfo.Column("typeFragment", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategoryChild = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategoryChild = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategoryChild = new TableInfo("CategoryChild", _columnsCategoryChild, _foreignKeysCategoryChild, _indicesCategoryChild);
        final TableInfo _existingCategoryChild = TableInfo.read(_db, "CategoryChild");
        if (! _infoCategoryChild.equals(_existingCategoryChild)) {
          throw new IllegalStateException("Migration didn't properly handle CategoryChild(com.trang.ez_mobile.model.entity.categories.CategoryChild).\n"
                  + " Expected:\n" + _infoCategoryChild + "\n"
                  + " Found:\n" + _existingCategoryChild);
        }
      }
    }, "b0db381e6149f5d9ad07049745030218", "476f8f12253e955ddc16eb1bf014f556");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "CategoryChild");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `CategoryChild`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ICategoryChildDao dao() {
    if (_iCategoryChildDao != null) {
      return _iCategoryChildDao;
    } else {
      synchronized(this) {
        if(_iCategoryChildDao == null) {
          _iCategoryChildDao = new ICategoryChildDao_Impl(this);
        }
        return _iCategoryChildDao;
      }
    }
  }
}
