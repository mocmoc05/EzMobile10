package com.trang.ez_mobile.model.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.trang.ez_mobile.model.entity.categories.Category;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ICategoryDao_Impl implements ICategoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCategory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCategory;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCategory;

  public ICategoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCategory = new EntityInsertionAdapter<Category>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Category`(`id`,`name`,`name_en`,`typeGroup`,`typeFragment`,`isFavorite`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
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
        stmt.bindLong(4, value.getTypeGroup());
        stmt.bindLong(5, value.getTypeFragment());
        final int _tmp;
        _tmp = value.isFavorite() ? 1 : 0;
        stmt.bindLong(6, _tmp);
      }
    };
    this.__preparedStmtOfDeleteCategory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Category";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCategory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Category SET isFavorite= ? WHERE id =?";
        return _query;
      }
    };
  }

  @Override
  public void addCategory(Category category) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCategory.insert(category);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCategory() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCategory.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCategory.release(_stmt);
    }
  }

  @Override
  public void updateCategory(int id, boolean isFavorite) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCategory.acquire();
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
      __preparedStmtOfUpdateCategory.release(_stmt);
    }
  }

  @Override
  public List<Category> getAll() {
    final String _sql = "SELECT * FROM Category";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfTypeGroup = _cursor.getColumnIndexOrThrow("typeGroup");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpTypeGroup;
        _tmpTypeGroup = _cursor.getInt(_cursorIndexOfTypeGroup);
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new Category(_tmpName,_tmpName_en,_tmpTypeGroup,_tmpTypeFragment,_tmpIsFavorite);
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
  public List<Category> getAllCategory() {
    final String _sql = "SELECT *FROM Category WHERE typeGroup != 1005";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfTypeGroup = _cursor.getColumnIndexOrThrow("typeGroup");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpTypeGroup;
        _tmpTypeGroup = _cursor.getInt(_cursorIndexOfTypeGroup);
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new Category(_tmpName,_tmpName_en,_tmpTypeGroup,_tmpTypeFragment,_tmpIsFavorite);
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
  public List<Category> getAllTitle() {
    final String _sql = "SELECT *FROM CATEGORY WHERE typeGroup = 1005";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfTypeGroup = _cursor.getColumnIndexOrThrow("typeGroup");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpTypeGroup;
        _tmpTypeGroup = _cursor.getInt(_cursorIndexOfTypeGroup);
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new Category(_tmpName,_tmpName_en,_tmpTypeGroup,_tmpTypeFragment,_tmpIsFavorite);
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
  public List<Category> getAllCategory(int typeGroup) {
    final String _sql = "SELECT *FROM Category WHERE typeGroup = ? AND isFavorite=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, typeGroup);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfTypeGroup = _cursor.getColumnIndexOrThrow("typeGroup");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpTypeGroup;
        _tmpTypeGroup = _cursor.getInt(_cursorIndexOfTypeGroup);
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new Category(_tmpName,_tmpName_en,_tmpTypeGroup,_tmpTypeFragment,_tmpIsFavorite);
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
  public List<Category> getAllCategoryToSetting() {
    final String _sql = "SELECT *FROM CATEGORY WHERE typeGroup != 1005 AND typeGroup != 1004";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfTypeGroup = _cursor.getColumnIndexOrThrow("typeGroup");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpTypeGroup;
        _tmpTypeGroup = _cursor.getInt(_cursorIndexOfTypeGroup);
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new Category(_tmpName,_tmpName_en,_tmpTypeGroup,_tmpTypeFragment,_tmpIsFavorite);
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
  public List<Category> getAllFravorite() {
    final String _sql = "SELECT *FROM CATEGORY WHERE isFavorite = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfTypeGroup = _cursor.getColumnIndexOrThrow("typeGroup");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpTypeGroup;
        _tmpTypeGroup = _cursor.getInt(_cursorIndexOfTypeGroup);
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new Category(_tmpName,_tmpName_en,_tmpTypeGroup,_tmpTypeFragment,_tmpIsFavorite);
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
  public List<Category> getAllCategorySub(int typeGroup) {
    final String _sql = "SELECT * FROM CATEGORY WHERE typeGroup = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, typeGroup);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfTypeGroup = _cursor.getColumnIndexOrThrow("typeGroup");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpTypeGroup;
        _tmpTypeGroup = _cursor.getInt(_cursorIndexOfTypeGroup);
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new Category(_tmpName,_tmpName_en,_tmpTypeGroup,_tmpTypeFragment,_tmpIsFavorite);
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
  public int getCategoryId(String name) {
    final String _sql = "SELECT id FROM CATEGORY WHERE name =? LIMIT 1";
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
  public Category getCategoryFromId(int id) {
    final String _sql = "SELECT * FROM CATEGORY WHERE id =? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfNameEn = _cursor.getColumnIndexOrThrow("name_en");
      final int _cursorIndexOfTypeGroup = _cursor.getColumnIndexOrThrow("typeGroup");
      final int _cursorIndexOfTypeFragment = _cursor.getColumnIndexOrThrow("typeFragment");
      final int _cursorIndexOfIsFavorite = _cursor.getColumnIndexOrThrow("isFavorite");
      final Category _result;
      if(_cursor.moveToFirst()) {
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpName_en;
        _tmpName_en = _cursor.getString(_cursorIndexOfNameEn);
        final int _tmpTypeGroup;
        _tmpTypeGroup = _cursor.getInt(_cursorIndexOfTypeGroup);
        final int _tmpTypeFragment;
        _tmpTypeFragment = _cursor.getInt(_cursorIndexOfTypeFragment);
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _result = new Category(_tmpName,_tmpName_en,_tmpTypeGroup,_tmpTypeFragment,_tmpIsFavorite);
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
