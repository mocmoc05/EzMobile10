package com.trang.ez_mobile.view.user.navi.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.trang.ez_mobile.databinding.ItemMainMenuRecyclerviewContentBinding;
import com.trang.ez_mobile.model.entity.categories.CategoryChild;
import com.trang.ez_mobile.view.user.navi.INavView;

import java.util.List;

import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.LANGUAGE_EN;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_LANGUAGE;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_CATEGORYCHILD;

/**
 * Created by TraPTH on 2/1/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CategoryChild> categories;
    LayoutInflater inflater;
    ItemMainMenuRecyclerviewContentBinding contentBinding;
    INavView.IOnClickListener listener;

    public CategoryAdapter(List<CategoryChild> categories, Context context, INavView.IOnClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.categories = categories;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        contentBinding =
                ItemMainMenuRecyclerviewContentBinding.inflate(inflater, parent, false);
        return new GroupHolder(contentBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GroupHolder) holder).bind(categories.get(position));
        holder.itemView.setOnClickListener(v -> {
            listener.onClickItemListener(categories.get(position).getId(), TYPE_MENU_CATEGORYCHILD);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public int getItemViewType(int position) {
        return categories.get(position).getCategoryId();
    }

    class GroupHolder extends RecyclerView.ViewHolder {
        ItemMainMenuRecyclerviewContentBinding contentBinding;

        public GroupHolder(ItemMainMenuRecyclerviewContentBinding contentBinding) {
            super(contentBinding.getRoot());
            this.contentBinding = contentBinding;
        }

        public void bind(CategoryChild child) {
            SharedPreferences preferences = getInstance().getSharedPreferences(SHARED_PREFRENCES_LANGUAGE, Context.MODE_PRIVATE);
            int language = preferences.getInt(SHARED_PREFRENCES_LANGUAGE, LANGUAGE_EN);
            contentBinding.category.setText(language == LANGUAGE_EN ? child.getName_en() : child.getName());
        }
    }
}
