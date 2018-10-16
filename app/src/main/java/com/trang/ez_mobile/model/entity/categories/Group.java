package com.trang.ez_mobile.model.entity.categories;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TraPTH on 1/31/2018.
 */

public class Group {
    private Category category;

    private List<CategoryChild> categories = new ArrayList<>();

    public Group(Category category) {
        this.category = category;
    }

    public Group(Category category, List<CategoryChild> categories) {
        this.category = category;
        this.categories = categories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<CategoryChild> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryChild> categories) {
        this.categories = categories;
    }
}