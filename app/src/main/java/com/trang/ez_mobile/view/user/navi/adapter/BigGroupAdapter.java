package com.trang.ez_mobile.view.user.navi.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.google.gson.Gson;
import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ItemMainMenuBiggroupContentBinding;
import com.trang.ez_mobile.databinding.ItemMainMenuBiggroupHeaderAccountBinding;
import com.trang.ez_mobile.databinding.ItemMainMenuBiggroupHeaderBinding;
import com.trang.ez_mobile.model.entity.categories.BigGroup;
import com.trang.ez_mobile.model.entity.categories.Group;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.user.login.TaiKhoan;
import com.trang.ez_mobile.view.user.navi.INavView;

import java.util.ArrayList;
import java.util.List;

import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.LANGUAGE_EN;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_LANGUAGE;
import static com.trang.ez_mobile.util.Define.TYPE_DATABASE_SETTING;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_CATEGORY;

/**
 * Created by TraPTH on 2/1/2018.
 */

public class BigGroupAdapter extends BaseExpandableListAdapter implements INavView.IOnClickListener {
    private SparseArray<BigGroup> sparseArray;
    //    CategoryAdapter listAdapter;
    View.OnClickListener listener;
    INavView.IOnClickListener iOnClickListener;
    List<View> accountView = new ArrayList<>();
    List<View> headerView = new ArrayList<>();
    List<List<View>> childView = new ArrayList<>();

    //Luu trang thai
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String keyShered = "account";

    public BigGroupAdapter(SparseArray<BigGroup> sparseArray,
                           View.OnClickListener listener, INavView.IOnClickListener iOnClickListener) {
        this.sparseArray = sparseArray;
        this.listener = listener;
        this.iOnClickListener = iOnClickListener;
        for (int i = 0; i < sparseArray.size(); i++) {
            childView.add(new ArrayList<>());
        }
    }

    @Override
    public int getGroupCount() {
        return sparseArray.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return sparseArray.get(groupPosition).getGroupSparseArray().size();
    }

    @Override
    public BigGroup getGroup(int groupPosition) {
        return sparseArray.get(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public Group getChild(int groupPosition, int childPosition) {
        return sparseArray.get(groupPosition).getGroupSparseArray().get(childPosition);
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
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, final boolean isExpanded, View convertView, ViewGroup parent) {
        if (groupPosition == 0) {
            //ACCOUNT
            if (accountView.size() > groupPosition) {
                return accountView.get(groupPosition);
            }

            ItemMainMenuBiggroupHeaderAccountBinding accountBinding =
                    ItemMainMenuBiggroupHeaderAccountBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

            //Lay thông tin Account
            sharedPreferences = App.getInstance().getSharedPreferences(Define.SHARED_PREFERENCES_ACCOUNT, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();

            if (getTaiKhoan() != null) {
                TaiKhoan taiKhoan = getTaiKhoan();

                if (taiKhoan.getMaTK() != null) {
                    accountBinding.textviewUsername.setText(taiKhoan.getMaTK() + " - " + taiKhoan.getTenTk());
                    accountBinding.textviewUserLogout.setVisibility(View.VISIBLE);
                    //bat su kien Logout
                    accountBinding.textviewUserLogout.setOnClickListener(listener);
                }

            } else {
                accountBinding.textviewUsername.setText("LOGIN");
                accountBinding.textviewUserLogout.setVisibility(View.INVISIBLE);
                //Bat su kien login
                accountBinding.textviewUsername.setOnClickListener(listener);

            }

            accountView.add(0, new AccountHolder(accountBinding).itemView);
            return accountView.get(0);
//            return new AccountHolder(accountBinding).itemView;
        }
        //------------------------------------------------------
        if (headerView.size() > groupPosition) {
            return headerView.get(groupPosition - 1);
        }
        final ItemMainMenuBiggroupHeaderBinding headerBinding =
                ItemMainMenuBiggroupHeaderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        headerBinding.header.setText(sparseArray.get(groupPosition).getTitle());
        headerView.add(new HeaderHolder(headerBinding).itemView);
        return headerView.get(headerView.size() - 1);
//        return new HeaderHolder(headerBinding).itemView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        if (childView.get(groupPosition).size() > childPosition) {
            return childView.get(groupPosition).get(childPosition);
        }
        SharedPreferences preferences = getInstance()
                .getSharedPreferences(SHARED_PREFRENCES_LANGUAGE, Context.MODE_PRIVATE);

        int language = preferences.getInt(SHARED_PREFRENCES_LANGUAGE, LANGUAGE_EN);
        final Group group = getChild(groupPosition, childPosition);
        //Settings
        if (group.getCategory().getTypeGroup() == TYPE_DATABASE_SETTING) {
        }
        //Main
        final ItemMainMenuBiggroupContentBinding contentBinding =
                ItemMainMenuBiggroupContentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        contentBinding.header.setText(language == LANGUAGE_EN ? group.getCategory().getName_en()
                : group.getCategory().getName());
        if (group.getCategories().size() > 0) {
            contentBinding.imageviewArrow.setVisibility(View.VISIBLE);
            if (contentBinding.recyclerView.getVisibility() == View.VISIBLE)
                contentBinding.viewDivider.setVisibility(View.VISIBLE);
        }
        CategoryAdapter listviewAdapter = new CategoryAdapter(group.getCategories(), App.getInstance(), this);
        contentBinding.recyclerView.setAdapter(listviewAdapter);
        contentBinding.recyclerView.setLayoutManager(new LinearLayoutManager(App.getInstance()));
        contentBinding.linearlayoutHeader.setOnClickListener(v -> {
            if (group.getCategories().size() > 0) {
                if (contentBinding.recyclerView.getVisibility() == View.GONE) {
                    contentBinding.imageviewArrow.setImageDrawable(App.getInstance().getResources().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
                    contentBinding.recyclerView.setVisibility(View.VISIBLE);
                    contentBinding.viewDivider.setVisibility(View.VISIBLE);
                } else {
                    contentBinding.imageviewArrow.setImageDrawable(App.getInstance().getResources().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
                    contentBinding.recyclerView.setVisibility(View.GONE);
                    contentBinding.viewDivider.setVisibility(View.GONE);
                }
            } else {
                contentBinding.imageviewArrow.setVisibility(View.GONE);
                iOnClickListener.onClickItemListener(group.getCategory().getId(), TYPE_MENU_CATEGORY);
            }
        });
        childView.get(groupPosition).add(new ChildHolder(contentBinding).itemView);
        return childView.get(groupPosition).get(childView.get(groupPosition).size() - 1);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public void onClickItemListener(int id, int type) {
        iOnClickListener.onClickItemListener(id, type);
    }

    public TaiKhoan getTaiKhoan() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(keyShered, "");
        TaiKhoan obj = gson.fromJson(json, TaiKhoan.class);
        return obj;
    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        ItemMainMenuBiggroupHeaderBinding binding;

        public HeaderHolder(ItemMainMenuBiggroupHeaderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class ChildHolder extends RecyclerView.ViewHolder {
        ItemMainMenuBiggroupContentBinding binding;

        public ChildHolder(ItemMainMenuBiggroupContentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class AccountHolder extends RecyclerView.ViewHolder {
        public AccountHolder(ItemMainMenuBiggroupHeaderAccountBinding accountBinding) {
            super(accountBinding.getRoot());
        }
    }
}
