package com.trang.ez_mobile.view.watchlist.model;

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
public class TableDatabase_Impl extends TableDatabase {
  private volatile WatchlistDao _watchlistDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `WatchlistData` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `sort` INTEGER NOT NULL, `check` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"ccde4d9028517a76079e4fc6f7a65e91\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `WatchlistData`");
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
        final HashMap<String, TableInfo.Column> _columnsWatchlistData = new HashMap<String, TableInfo.Column>(4);
        _columnsWatchlistData.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1));
        _columnsWatchlistData.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsWatchlistData.put("sort", new TableInfo.Column("sort", "INTEGER", true, 0));
        _columnsWatchlistData.put("check", new TableInfo.Column("check", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWatchlistData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWatchlistData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWatchlistData = new TableInfo("WatchlistData", _columnsWatchlistData, _foreignKeysWatchlistData, _indicesWatchlistData);
        final TableInfo _existingWatchlistData = TableInfo.read(_db, "WatchlistData");
        if (! _infoWatchlistData.equals(_existingWatchlistData)) {
          throw new IllegalStateException("Migration didn't properly handle WatchlistData(com.trang.ez_mobile.model.entity.chart.WatchlistData).\n"
                  + " Expected:\n" + _infoWatchlistData + "\n"
                  + " Found:\n" + _existingWatchlistData);
        }
      }
    }, "ccde4d9028517a76079e4fc6f7a65e91", "87202c262ecace7408ecf09d5549a09a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "WatchlistData");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `WatchlistData`");
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
  public WatchlistDao userDao() {
    if (_watchlistDao != null) {
      return _watchlistDao;
    } else {
      synchronized(this) {
        if(_watchlistDao == null) {
          _watchlistDao = new WatchlistDao_Impl(this);
        }
        return _watchlistDao;
      }
    }
  }
}
