package com.trang.ez_mobile.view.marketOverview.market.model;

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
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class MarketDatabase_Impl extends MarketDatabase {
  private volatile IMarketOverviewMarketDao _iMarketOverviewMarketDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MarketData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `marketName` TEXT, `isSave` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"78b40cfe18a715407b21cd2008efee15\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `MarketData`");
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
        final HashMap<String, TableInfo.Column> _columnsMarketData = new HashMap<String, TableInfo.Column>(3);
        _columnsMarketData.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsMarketData.put("marketName", new TableInfo.Column("marketName", "TEXT", false, 0));
        _columnsMarketData.put("isSave", new TableInfo.Column("isSave", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMarketData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMarketData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMarketData = new TableInfo("MarketData", _columnsMarketData, _foreignKeysMarketData, _indicesMarketData);
        final TableInfo _existingMarketData = TableInfo.read(_db, "MarketData");
        if (! _infoMarketData.equals(_existingMarketData)) {
          throw new IllegalStateException("Migration didn't properly handle MarketData(com.trang.ez_mobile.view.marketOverview.market.model.MarketData).\n"
                  + " Expected:\n" + _infoMarketData + "\n"
                  + " Found:\n" + _existingMarketData);
        }
      }
    }, "78b40cfe18a715407b21cd2008efee15", "7ff964cdd5c7398119ab1dcb590a3c9a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "MarketData");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `MarketData`");
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
  public IMarketOverviewMarketDao dao() {
    if (_iMarketOverviewMarketDao != null) {
      return _iMarketOverviewMarketDao;
    } else {
      synchronized(this) {
        if(_iMarketOverviewMarketDao == null) {
          _iMarketOverviewMarketDao = new IMarketOverviewMarketDao_Impl(this);
        }
        return _iMarketOverviewMarketDao;
      }
    }
  }
}
