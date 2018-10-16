package com.trang.ez_mobile.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.trang.ez_mobile.model.entity.categories.Category;

import java.util.List;


/**
 * Created by TraPTH on 1/27/2018.
 */
@Dao
public interface ICategoryDao {

    @Query("DELETE FROM Category")
    void deleteCategory();

    @Query("SELECT * FROM Category")
    List<Category> getAll();

    @Query("SELECT *FROM Category WHERE typeGroup != 1005")
    List<Category> getAllCategory();

    @Query("SELECT *FROM CATEGORY WHERE typeGroup = 1005")
    List<Category> getAllTitle();

    @Query("SELECT *FROM Category WHERE typeGroup = :typeGroup AND isFavorite=0")
    List<Category> getAllCategory(int typeGroup);

    //1005 TYPE -TITLE
    //1004 TYPE -SETTING
    @Query("SELECT *FROM CATEGORY WHERE typeGroup != 1005 AND typeGroup != 1004")
    List<Category> getAllCategoryToSetting();

    @Query("SELECT *FROM CATEGORY WHERE isFavorite = 1")
    List<Category> getAllFravorite();

    @Query("UPDATE Category SET isFavorite= :isFavorite WHERE id =:id")
    void updateCategory(int id, boolean isFavorite);

    @Insert
    void addCategory(Category category);


    @Query("SELECT * FROM CATEGORY WHERE typeGroup = :typeGroup")
    List<Category> getAllCategorySub(int typeGroup);

    @Query("SELECT id FROM CATEGORY WHERE name =:name LIMIT 1")
    int getCategoryId(String name);

    @Query("SELECT * FROM CATEGORY WHERE id =:id LIMIT 1")
    Category getCategoryFromId(int id);

}
