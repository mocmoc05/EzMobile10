package com.trang.ez_mobile.view.user.navi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ItemMainMenuRecyclerviewContentBinding;
import com.trang.ez_mobile.model.entity.categories.Category;

import java.util.Collections;
import java.util.List;

/**
 * Created by TraPTH on 1/31/2018.
 */

public class SettingAdapter extends BaseAdapter {
    List<Category> categories = Collections.emptyList();

    ItemMainMenuRecyclerviewContentBinding settingBinding;

    public List<Category> getCategories() {
        return categories;
    }

    public SettingAdapter(List<Category> categories) {
        this.categories = categories;
    }

    public void setCategory(int position, boolean isChecked) {
        categories.get(position).setFavorite(isChecked);
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Category getItem(int position) {
        if (position >= 0 && position < categories.size())
            return categories.get(position);
        else return new Category();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return categories.get(position).getTypeGroup();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        settingBinding = ItemMainMenuRecyclerviewContentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        settingBinding.executePendingBindings();

        final Category category = categories.get(position);
        settingBinding.category.setText(category.getName());
        settingBinding.imageViewIsFavorite.setVisibility(View.VISIBLE);
        settingBinding.imageViewIsFavorite.setImageResource(category.isFavorite() ?
                R.drawable.ic_user_setting_checked_true : R.drawable.ic_user_setting_checked);
//============================
//        settingBinding.setIsFavorite(category.isFavorite());

        return new SettingHolder(settingBinding).itemView;
    }

    class SettingHolder extends RecyclerView.ViewHolder {
        public SettingHolder(ItemMainMenuRecyclerviewContentBinding contentBinding) {
            super(contentBinding.getRoot());
        }
    }

}
