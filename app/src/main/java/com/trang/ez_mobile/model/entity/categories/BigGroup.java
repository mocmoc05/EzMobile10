package com.trang.ez_mobile.model.entity.categories;

import android.util.SparseArray;

/**
 * Created by TraPTH on 2/1/2018.
 */

public class BigGroup {
    private String title;
    private SparseArray<Group> groupSparseArray;

    public BigGroup() {
    }

    public BigGroup(String title, SparseArray<Group> groupList) {
        this.title = title;
        this.groupSparseArray = groupList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SparseArray<Group> getGroupSparseArray() {
        return groupSparseArray;
    }

    public void setGroupSparseArray(SparseArray<Group> groupSparseArray) {
        this.groupSparseArray = groupSparseArray;
    }
}
