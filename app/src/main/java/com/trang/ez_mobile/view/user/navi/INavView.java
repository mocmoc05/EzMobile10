package com.trang.ez_mobile.view.user.navi;

import android.util.SparseArray;


import com.trang.ez_mobile.model.entity.categories.BigGroup;
import com.trang.ez_mobile.model.entity.categories.Category;

import java.util.List;

/**
 * Created by TraPTH on 1/27/2018.
 */

public interface INavView {
    void onDisplay(SparseArray<BigGroup> groups);

    void onSetting(List<Category> categories);

    void onSetFragment(int id);

    interface IOnClickListener{

        void onClickItemListener(int id, int type);
    }
}
