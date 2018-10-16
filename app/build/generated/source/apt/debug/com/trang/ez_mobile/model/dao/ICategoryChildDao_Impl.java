package com.trang.ez_mobile.model.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.trang.ez_mobile.model.entity.categories.CategoryChild;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ICategoryChildDao_Impl implements ICategoryChildDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCategoryChild;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCategoryChild;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCategoryChild;

  public ICategoryChildDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCategoryChild = new EntityInsertionAdapter<CategoryChild>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `CategoryChild`(`id`,`name`,`name_en`,`categoryId`,`isFavorite`,`typeFragment`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CategoryChild value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getName_en() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName_en());
        }
        stmt.bindLong(4, value.getCategoryId());
        final int _tmp;
        _tmp = value.isFavorite() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindLong(6, value.getTypeFragment());
      }
    };
    this.__preparedStmtOfDeleteCategoryChild = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM CategoryChild";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCategoryChild = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE CategoryChild SET isFavorite= ? WHERE id =?";
        return _query;
      }
    };
  }

  @Override
  public void addCategoryChild(CategoryChild child) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCategoryChild.insert(child);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCategoryChild() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCategoryChild.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCategoryChild.release(_stmt);
    }
  }

  @Override
  public void updateCategoryChild(int id, boolean isFavorite) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCategoryChild.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      final int _tmp;
      _tmp = isFavorite ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCategoryChild.release(_stmt);
    }
  }

  @Override
  public List<CategoryChild> getAllCategoryChild() {
    final String _sql = "SELECT *FROM CATEGORYCHILD";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfCategoryId = _cursor.getColumnIndexOrThrow("categoryId");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final List<CategoryChild> _result = new ArrayList<CategoryChild>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CategoryChild _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpCategoryId;
        _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        _item = new CategoryChild(_tmpName,_tmpName_en,_tmpCategoryId,_tmpTypeFragment,_tmpIsFavorite);
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
  public List<CategoryChild> getAllChildIsFavorite() {
    final String _sql = "SELECT *FROM CATEGORYCHILD WHERE isFavorite=1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfCategoryId = _cursor.getColumnIndexOrThrow("categoryId");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final List<CategoryChild> _result = new ArrayList<CategoryChild>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CategoryChild _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpCategoryId;
        _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        _item = new CategoryChild(_tmpName,_tmpName_en,_tmpCategoryId,_tmpTypeFragment,_tmpIsFavorite);
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
  public List<CategoryChild> getAllCategoryChild(int categoryId) {
    final String _sql = "SELECT *FROM categorychild  WHERE categoryId =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, categoryId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfCategoryId = _cursor.getColumnIndexOrThrow("categoryId");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final List<CategoryChild> _result = new ArrayList<CategoryChild>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CategoryChild _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpCategoryId;
        _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        _item = new CategoryChild(_tmpName,_tmpName_en,_tmpCategoryId,_tmpTypeFragment,_tmpIsFavorite);
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
  public List<CategoryChild> getAllByCategoryId(int categoryId) {
    final String _sql = "SELECT *FROM CATEGORYCHILD WHERE categoryId =? AND isFavorite = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, categoryId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfCategoryId = _cursor.getColumnIndexOrThrow("categoryId");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final List<CategoryChild> _result = new ArrayList<CategoryChild>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CategoryChild _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpCategoryId;
        _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        _item = new CategoryChild(_tmpName,_tmpName_en,_tmpCategoryId,_tmpTypeFragment,_tmpIsFavorite);
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
  public CategoryChild getCategoryChildFromId(int id) {
    final String _sql = "SELECT * FROM CATEGORYCHILD WHERE id =? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfCategoryId = _cursor.getColumnIndexOrThrow("categoryId");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final CategoryChild _result;
      if(_cursor.moveToFirst()) {
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpCategoryId;
        _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        _result = new CategoryChild(_tmpName,_tmpName_en,_tmpCategoryId,_tmpTypeFragment,_tmpIsFavorite);
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
