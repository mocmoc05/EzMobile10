package com.trang.ez_mobile.view.user.navi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ItemMainMenuBiggroupHeaderAccountBinding;
import com.trang.ez_mobile.databinding.ItemMainMenuRecyclerviewContentBinding;
import com.trang.ez_mobile.databinding.NavUserLayoutBinding;
import com.trang.ez_mobile.model.entity.categories.BigGroup;
import com.trang.ez_mobile.model.entity.categories.Category;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.splash_screen.IMainListener;
import com.trang.ez_mobile.view.splash_screen.MainActivity;
import com.trang.ez_mobile.view.user.login.TaiKhoan;
import com.trang.ez_mobile.view.user.navi.adapter.BigGroupAdapter;
import com.trang.ez_mobile.view.user.navi.adapter.SettingAdapter;

import java.util.List;

import static android.view.LayoutInflater.from;

/**
 * Created by TraPTH on 1/30/2018.
 */

public class CustomNavigation implements INavView, AdapterView.OnItemClickListener,
        View.OnClickListener, INavView.IOnClickListener {

    Activity activity;
    SettingAdapter settingAdapter;
    IMainListener listener;
    NavUserLayoutBinding binding;

    NavPresenter presenter;
    BigGroupAdapter listAdapter;

    //Luu trang thai
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String keyShered = "account";
    private String keyCheck= "check_account";

    public CustomNavigation(Activity activity, IMainListener listener, NavUserLayoutBinding binding) {
        this.activity = activity;
        this.listener = listener;
        this.binding = binding;
    }

    public void onStart() {
        presenter = new NavPresenter(App.getInstance(), this);
        binding.listviewSetting.setOnItemClickListener(this);
        binding.expandedListview.setChildIndicator(null);
        binding.expandedListview.setDividerHeight(0);
        binding.actionSave.setOnClickListener(this);
    }

    @Override
    public void onDisplay(SparseArray<BigGroup> groups) {
        binding.linearlayoutContent.setVisibility(View.VISIBLE);
        binding.linearlayoutSetting.setVisibility(View.GONE);
        listAdapter = new BigGroupAdapter(groups, this, this);
        binding.expandedListview.setAdapter(listAdapter);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            binding.expandedListview.expandGroup(i);
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSetting(List<Category> categories) {
        binding.linearlayoutContent.setVisibility(View.GONE);
        binding.linearlayoutSetting.setVisibility(View.VISIBLE);
        settingAdapter = new SettingAdapter(categories);
        binding.listviewSetting.setAdapter(settingAdapter);
        settingAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSetFragment(int typeFragmet) {
        listener.onReplaceFragment(typeFragmet);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //settings
        Category category = settingAdapter.getItem(position);
        category.setFavorite(!category.isFavorite());
        ItemMainMenuRecyclerviewContentBinding contentBinding =
                ItemMainMenuRecyclerviewContentBinding.inflate(from(parent.getContext()), parent, false);
        contentBinding.imageViewIsFavorite.setVisibility(View.VISIBLE);
        contentBinding.imageViewIsFavorite.setImageResource(category.isFavorite() ?
                R.drawable.ic_user_setting_checked_true : R.drawable.ic_user_setting_checked);
        contentBinding.executePendingBindings();

        settingAdapter.setCategory(position, category.isFavorite());
        settingAdapter.notifyDataSetChanged();
    }

    //Su ly su kien Nav header tai class BigGroupAdapter
    @Override
    public void onClick(View v) {
        ItemMainMenuBiggroupHeaderAccountBinding accountBinding =
                ItemMainMenuBiggroupHeaderAccountBinding.inflate(from(App.getInstance()));

        if (v.getId() == accountBinding.textviewUsername.getId()) {
            presenter.onClickSetFragment(Define.MENU_LOGIN);

        } else if (v.getId() == accountBinding.textviewUserLogout.getId()) {
            sharedPreferences = App.getInstance().getSharedPreferences(Define.SHARED_PREFERENCES_ACCOUNT, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putBoolean(keyCheck, false);
            saveTaiKhoan(new TaiKhoan());

            activity.finish();
            activity.startActivity(new Intent(activity, MainActivity.class));

//            presenter.onSetting();
        } else if (v.getId() == binding.actionSave.getId()) {
            presenter.onUpdateNav(settingAdapter.getCategories());
        }
    }

    //Su kien Nav
    @Override
    public void onClickItemListener(int id, int type) {
        presenter.onClickListener(id, type);
    }

    public void saveTaiKhoan(TaiKhoan taiKhoan) {
        Gson gson = new Gson();
        String json = gson.toJson(taiKhoan);
        editor.putString(keyShered, json);
        editor.commit();
    }
}
