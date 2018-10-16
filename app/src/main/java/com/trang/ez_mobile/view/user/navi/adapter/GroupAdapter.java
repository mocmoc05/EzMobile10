package com.trang.ez_mobile.view.user.navi.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.trang.ez_mobile.databinding.ItemMainMenuGroupContentBinding;
import com.trang.ez_mobile.databinding.ItemMainMenuGroupHeaderBinding;
import com.trang.ez_mobile.model.entity.categories.Category;
import com.trang.ez_mobile.model.entity.categories.CategoryChild;
import com.trang.ez_mobile.model.entity.categories.Group;

/**
 * Created by TraPTH on 3/2/2018.
 */

public class GroupAdapter extends BaseExpandableListAdapter {
    private SparseArray<Group> sparseArray;
    LayoutInflater inflater;
    Activity activity;

    public GroupAdapter(SparseArray<Group> sparseArray, Activity activity) {
        this.sparseArray = sparseArray;
        this.inflater = activity.getLayoutInflater();
        this.activity = activity;
        Log.w("GroupAdapter", "GroupAdapter: " + sparseArray.size());
    }

    @Override
    public int getGroupCount() {
        return sparseArray.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return sparseArray.get(groupPosition).getCategories().size();
    }

    @Override
    public Group getGroup(int groupPosition) {
        return sparseArray.get(groupPosition);
    }

    @Override
    public CategoryChild getChild(int groupPosition, int childPosition) {
        return sparseArray.get(groupPosition).getCategories().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ItemMainMenuGroupHeaderBinding headerBinding = ItemMainMenuGroupHeaderBinding.inflate(inflater);

        headerBinding.header.setText(getGroup(groupPosition).getCategory().getName());
        Log.w("GroupAdapter", "getGroupView: " + getGroup(groupPosition).getCategory().getName() + " " + groupPosition);
        return new HeaderHolder(headerBinding).itemView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (sparseArray.get(groupPosition).getCategories().size() > 0) {
            ItemMainMenuGroupContentBinding contentBinding = ItemMainMenuGroupContentBinding.inflate(inflater);

            CategoryChild categoryChild = sparseArray.get(groupPosition).getCategories().get(childPosition);
            Log.w("GroupAdapter", "getChildView: " + groupPosition + " " + childPosition + " " + categoryChild.getName());
            contentBinding.category.setText(categoryChild.getName());

            return new ContentHolder(contentBinding).itemView;
        } else {
            return null;
        }
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        ItemMainMenuGroupHeaderBinding binding;

        public HeaderHolder(ItemMainMenuGroupHeaderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Category category) {
            binding.header.setText(category.getName());
        }
    }

    class ContentHolder extends RecyclerView.ViewHolder {
        ItemMainMenuGroupContentBinding binding;

        public ContentHolder(ItemMainMenuGroupContentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
