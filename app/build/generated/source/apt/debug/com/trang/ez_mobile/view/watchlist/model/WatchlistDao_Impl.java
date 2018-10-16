package com.trang.ez_mobile.view.watchlist.model;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.trang.ez_mobile.model.entity.chart.WatchlistData;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class WatchlistDao_Impl implements WatchlistDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfWatchlistData;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public WatchlistDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWatchlistData = new EntityInsertionAdapter<WatchlistData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `WatchlistData`(`mId`,`name`,`sort`,`check`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WatchlistData value) {
        stmt.bindLong(1, value.mId);
        if (value.getColumn() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getColumn());
        }
        stmt.bindLong(3, value.getSort());
        final int _tmp;
        _tmp = value.getCheck() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from WatchlistData";
        return _query;
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE WatchlistData SET name = ?, sort = ?, `check` = ? WHERE mId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertav(WatchlistData ent) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfWatchlistData.insert(ent);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public void update(String name, int sort, int check, long id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (name == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, name);
      }
      _argIndex = 2;
      _stmt.bindLong(_argIndex, sort);
      _argIndex = 3;
      _stmt.bindLong(_argIndex, check);
      _argIndex = 4;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public List<WatchlistData> getAll() {
    final String _sql = "select * from WatchlistData";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMId = _cursor.getColumnIndexOrThrow("mId");
      final int _cursorIndexOfColumn = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfSort = _cursor.getColumnIndexOrThrow("sort");
      final int _cursorIndexOfCheck = _cursor.getColumnIndexOrThrow("check");
      final List<WatchlistData> _result = new ArrayList<WatchlistData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WatchlistData _item;
        final String _tmpColumn;
        _tmpColumn = _cursor.getString(_cursorIndexOfColumn);
        final int _tmpSort;
        _tmpSort = _cursor.getInt(_cursorIndexOfSort);
        final boolean _tmpCheck;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfCheck);
        _tmpCheck = _tmp != 0;
        _item = new WatchlistData(_tmpColumn,_tmpSort,_tmpCheck);
        _item.mId = _cursor.getLong(_cursorIndexOfMId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int check(String name) {
    final String _sql = "select COUNT(*) from WatchlistData where name= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
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
  public int count() {
    final String _sql = "select COUNT(*) from WatchlistData";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
}
