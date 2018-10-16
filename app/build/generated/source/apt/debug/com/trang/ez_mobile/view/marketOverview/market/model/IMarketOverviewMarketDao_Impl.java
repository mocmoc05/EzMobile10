package com.trang.ez_mobile.view.marketOverview.market.model;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class IMarketOverviewMarketDao_Impl implements IMarketOverviewMarketDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMarketData;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public IMarketOverviewMarketDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMarketData = new EntityInsertionAdapter<MarketData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MarketData`(`id`,`marketName`,`isSave`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MarketData value) {
        stmt.bindLong(1, value.getId());
        if (value.getMarketName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMarketName());
        }
        final int _tmp;
        _tmp = value.isSave() ? 1 : 0;
        stmt.bindLong(3, _tmp);
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE MarketData SET isSave = ?  WHERE marketName = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(MarketData marketData) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMarketData.insert(marketData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(String marketName, boolean isSave) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      final int _tmp;
      _tmp = isSave ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      _argIndex = 2;
      if (marketName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, marketName);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public List<MarketData> getAll() {
    final String _sql = "SELECT * FROM MarketData";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfMarketName = _cursor.getColumnIndexOrThrow("marketName");
      final int _cursorIndexOfIsSave = _cursor.getColumnIndexOrThrow("isSave");
      final List<MarketData> _result = new ArrayList<MarketData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MarketData _item;
        final String _tmpMarketName;
        _tmpMarketName = _cursor.getString(_cursorIndexOfMarketName);
        final boolean _tmpIsSave;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSave);
        _tmpIsSave = _tmp != 0;
        _item = new MarketData(_tmpMarketName,_tmpIsSave);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MarketData> getAllCheck() {
    final String _sql = "SELECT * FROM MarketData WHERE isSave = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfMarketName = _cursor.getColumnIndexOrThrow("marketName");
      final int _cursorIndexOfIsSave = _cursor.getColumnIndexOrThrow("isSave");
      final List<MarketData> _result = new ArrayList<MarketData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MarketData _item;
        final String _tmpMarketName;
        _tmpMarketName = _cursor.getString(_cursorIndexOfMarketName);
        final boolean _tmpIsSave;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSave);
        _tmpIsSave = _tmp != 0;
        _item = new MarketData(_tmpMarketName,_tmpIsSave);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getMarketCheck(String marketName) {
    final String _sql = "SELECT isSave FROM MarketData WHERE marketName =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (marketName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, marketName);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public MarketData getMarket(String marketName) {
    final String _sql = "SELECT * FROM MarketData WHERE marketName = ? AND isSave = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (marketName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, marketName);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfMarketName = _cursor.getColumnIndexOrThrow("marketName");
      final int _cursorIndexOfIsSave = _cursor.getColumnIndexOrThrow("isSave");
      final MarketData _result;
      if(_cursor.moveToFirst()) {
        final String _tmpMarketName;
        _tmpMarketName = _cursor.getString(_cursorIndexOfMarketName);
        final boolean _tmpIsSave;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSave);
        _tmpIsSave = _tmp != 0;
        _result = new MarketData(_tmpMarketName,_tmpIsSave);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
