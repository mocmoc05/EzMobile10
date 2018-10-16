//package com.fpts.mobile.view.user.navi.adapter;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
//import com.fpts.mobile.databinding.ItemMainMenuRecyclerviewContentBinding;
//import com.fpts.mobile.model.entity.categories.CategoryChild;
//import com.fpts.mobile.view.user.navi.INavView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.fpts.mobile.App.getInstance;
//import static com.fpts.mobile.util.Define.LANGUAGE_EN;
//import static com.fpts.mobile.util.Define.SHARED_PREFRENCES_LANGUAGE;
//import static com.fpts.mobile.util.Define.TYPE_MENU_CATEGORYCHILD;
//
///**
// * Created by TraPTH on 2/1/2018.
// */
//
//public class CategoryListviewAdapter extends BaseAdapter {
//    private List<CategoryChild> categories;
//    LayoutInflater inflater;
//    ItemMainMenuRecyclerviewContentBinding contentBinding;
//    INavView.IOnClickListener listener;
//
//    public CategoryListviewAdapter(List<CategoryChild> categories, Context context, INavView.IOnClickListener listener) {
//        inflater = LayoutInflater.from(context);
//        this.categories = categories;
//        this.listener = listener;
//    }
//
//    @Override
//    public int getCount() {
//        return categories.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return categories.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    List<View> viewList = new ArrayList<>();
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (viewList.size() > position) {
//            return viewList.get(position);
//        }
//        contentBinding =
//                ItemMainMenuRecyclerviewContentBinding.inflate(inflater, parent, false);
//        CategoryChild child = categories.get(position);
//        SharedPreferences preferences = getInstance()
//                .getSharedPreferences(SHARED_PREFRENCES_LANGUAGE, Context.MODE_PRIVATE);
//        int language = preferences.getInt(SHARED_PREFRENCES_LANGUAGE, LANGUAGE_EN);
//        contentBinding.category.setText(language == LANGUAGE_EN ? child.getName_en() : child.getName());
//        contentBinding.linearlayoutContent.setOnClickListener(v -> {
//            listener.onClickItemListener(categories.get(position).getId(), TYPE_MENU_CATEGORYCHILD);
//        });
//        viewList.add(new GroupHolder(contentBinding).itemView);
//        return viewList.get(viewList.size() - 1);
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return categories.get(position).getCategoryId();
//    }
//
//    class GroupHolder extends RecyclerView.ViewHolder {
//        ItemMainMenuRecyclerviewContentBinding contentBinding;
//
//        public GroupHolder(ItemMainMenuRecyclerviewContentBinding contentBinding) {
//            super(contentBinding.getRoot());
//            this.contentBinding = contentBinding;
//        }
//    }
//}
