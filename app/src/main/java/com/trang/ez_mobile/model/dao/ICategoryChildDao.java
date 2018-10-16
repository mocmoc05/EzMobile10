package com.trang.ez_mobile.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.trang.ez_mobile.model.entity.categories.CategoryChild;

import java.util.List;


/**
 * Created by TraPTH on 2/1/2018.
 */
@Dao
public interface ICategoryChildDao {

    @Query("DELETE FROM CategoryChild")
    void deleteCategoryChild();

    @Query("UPDATE CategoryChild SET isFavorite= :isFavorite WHERE id =:id")
    void updateCategoryChild(int id, boolean isFavorite);

    @Insert
    void addCategoryChild(CategoryChild child);

    @Query("SELECT *FROM CATEGORYCHILD")
    List<CategoryChild> getAllCategoryChild();


    @Query("SELECT *FROM CATEGORYCHILD WHERE isFavorite=1")
    List<CategoryChild> getAllChildIsFavorite();

    @Query("SELECT *FROM categorychild  WHERE categoryId =:categoryId")
    List<CategoryChild> getAllCategoryChild(int categoryId);


    @Query("SELECT *FROM CATEGORYCHILD WHERE categoryId =:categoryId AND isFavorite = 0")
    List<CategoryChild> getAllByCategoryId(int categoryId);

    @Query("SELECT * FROM CATEGORYCHILD WHERE id =:id LIMIT 1")
    CategoryChild getCategoryChildFromId(int id);
}
