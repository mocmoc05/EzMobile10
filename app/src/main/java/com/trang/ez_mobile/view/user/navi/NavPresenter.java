package com.trang.ez_mobile.view.user.navi;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.SparseArray;

import com.trang.ez_mobile.model.db.CategoryChildDatabase;
import com.trang.ez_mobile.model.db.CategoryDatabase;
import com.trang.ez_mobile.model.entity.categories.BigGroup;
import com.trang.ez_mobile.model.entity.categories.Category;
import com.trang.ez_mobile.model.entity.categories.CategoryChild;
import com.trang.ez_mobile.model.entity.categories.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.arch.persistence.room.Room.databaseBuilder;
import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.CATEGORYCHILD_DB;
import static com.trang.ez_mobile.util.Define.CATEGORY_DB;
import static com.trang.ez_mobile.util.Define.LANGUAGE_EN;
import static com.trang.ez_mobile.util.Define.MENU_BAO_CAO_TAI_SAN;
import static com.trang.ez_mobile.util.Define.MENU_DAT_LENH;
import static com.trang.ez_mobile.util.Define.MENU_GOP_Y;
import static com.trang.ez_mobile.util.Define.MENU_HUONG_DAN_SU_DUNG;
import static com.trang.ez_mobile.util.Define.MENU_LICH_SU_UNG_TRUOC;
import static com.trang.ez_mobile.util.Define.MENU_LIEN_HE;
import static com.trang.ez_mobile.util.Define.MENU_MO_TAI_KHOAN;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_LANGUAGE;
import static com.trang.ez_mobile.util.Define.TYPE_DATABASE_FEATURES;
import static com.trang.ez_mobile.util.Define.TYPE_DATABASE_HELP;
import static com.trang.ez_mobile.util.Define.TYPE_DATABASE_MEMBER;
import static com.trang.ez_mobile.util.Define.TYPE_DATABASE_TITLE;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_CATEGORY;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_CATEGORYCHILD;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_CHART;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_EVENTS;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_HOME;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_MARKET_OVERRVIEW;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_NEWS;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_WATCHLIST;
import static com.trang.ez_mobile.util.Define.TYPE_MENU_WORLD_INDEX;

/**
 * Created by TraPTH on 1/27/2018.
 */

public class NavPresenter {

    private INavView iNav_view;
    private CategoryDatabase database;
    private CategoryChildDatabase childDatabase;
    Context context;

    public NavPresenter(Context context, INavView iNav_view) {
        this.context = context;
        this.iNav_view = iNav_view;
        database = databaseBuilder(context, CategoryDatabase.class, CATEGORY_DB)
                .fallbackToDestructiveMigration()
                .addMigrations(CategoryDatabase.MIGRATION_2_3)
                .allowMainThreadQueries().build();

        childDatabase = databaseBuilder(context, CategoryChildDatabase.class, CATEGORYCHILD_DB)
                .addMigrations(CategoryChildDatabase.MIGRATION_2_3)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();
        initilizeData();
        getData();

        database.close();
        childDatabase.close();
    }

    private void getData() {
        SharedPreferences preferences = getInstance()
                .getSharedPreferences(SHARED_PREFRENCES_LANGUAGE, Context.MODE_PRIVATE);

        int language = preferences.getInt(SHARED_PREFRENCES_LANGUAGE, LANGUAGE_EN);

        SparseArray<BigGroup> bigGroupSparseArray = new SparseArray<>();
        //account
        bigGroupSparseArray.append(bigGroupSparseArray.size(), new BigGroup("", new SparseArray<>()));
        //favorites
        List<CategoryChild> childIsFavorite = childDatabase.dao().getAllChildIsFavorite();
        List<Category> favorites = database.dao().getAllFravorite();
        for (int i = 0; i < childIsFavorite.size(); i++) {
            Category category = new Category(childIsFavorite.get(i).getName(), childIsFavorite.get(i).getName_en(),
                    0, childIsFavorite.get(i).getTypeFragment(), childIsFavorite.get(i).isFavorite());
            category.setId(childIsFavorite.get(i).getId());
            favorites.add(category);
        }
        SparseArray<Group> groups = new SparseArray<>();
        for (int j = 0; j < favorites.size(); j++) {
            Category category = favorites.get(j);
            List<CategoryChild> childList = childDatabase.dao().getAllByCategoryId(category.getId());
//            SparseArray<CategoryChild> childSparseArray = new SparseArray<>();
//            for (int i = 0; i < childList.size(); i++) {
//                childSparseArray.append(i, childList.get(i));
//            }
            groups.append(j, new Group(category, childList));
        }
        bigGroupSparseArray.append(bigGroupSparseArray.size(), new BigGroup(language == LANGUAGE_EN ? "Favorites" : "Yêu thích", groups));
        //normal
        List<List<Category>> lists = Arrays.asList(
                database.dao().getAllCategory(TYPE_DATABASE_FEATURES),
                database.dao().getAllCategory(TYPE_DATABASE_MEMBER),
                database.dao().getAllCategory(TYPE_DATABASE_HELP));
        List<Category> titles = database.dao().getAllTitle();

        for (int i = 0; i < lists.size(); i++) {
            List<Category> categories = lists.get(i);
            groups = new SparseArray<>();

            for (int j = 0; j < categories.size(); j++) {
                Category category = categories.get(j);
                List<CategoryChild> childList = childDatabase.dao().getAllByCategoryId(category.getId());
                groups.append(j, new Group(category, childList));
            }

            bigGroupSparseArray.append(bigGroupSparseArray.size(),
                    new BigGroup((language == LANGUAGE_EN ? titles.get(i + 1).getName_en() : titles.get(i + 1).getName()), groups));
        }
        if (iNav_view != null) {
            iNav_view.onDisplay(bigGroupSparseArray);
        }
    }

    public void onSetting() {
        //lấy ra list category
        //nếu List child category: size > 0: add từng phần tử vào list category trên
        List<Category> result = new ArrayList<>();
        List<Category> categories = database.dao().getAllCategoryToSetting();
        for (int i = 0; i < categories.size(); i++) {
            List<CategoryChild> children = childDatabase.dao().getAllCategoryChild(categories.get(i).getId());
            if (children.size() > 0) {
                for (int j = 0; j < children.size(); j++) {
                    result.add(new Category(children.get(j).getName(), children.get(j).getName_en(), 0, children.get(j).getTypeFragment(), children.get(j).isFavorite()));
                }
            } else {
                result.add(categories.get(i));
            }
        }
        if (iNav_view != null && result.size() > 0) {
            iNav_view.onSetting(result);
        }
    }

    public void onUpdateNav(List<Category> categories) {
        if (categories == null || categories.size() == 0) {
            return;
        }
        //tách categories và childcategory
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() > 0) {
                database.dao().updateCategory(categories.get(i).getId(), categories.get(i).isFavorite());
                categories.remove(i);
                i--;
            }
        }
        //phần category child
        List<CategoryChild> categoryChildren = childDatabase.dao().getAllCategoryChild();
        for (int i = 0; i < categories.size(); i++) {
            childDatabase.dao().updateCategoryChild(categoryChildren.get(i).getId(), categories.get(i).isFavorite());
        }
        getData();
    }

    /**
     * @param categoryId
     */
    public void onClickListener(int categoryId, int type) {
        if (type == TYPE_MENU_CATEGORY) {
            try {
                Category category = database.dao().getCategoryFromId(categoryId);
                iNav_view.onSetFragment(category.getTypeFragment());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type == TYPE_MENU_CATEGORYCHILD) {
            try {
                CategoryChild child = childDatabase.dao().getCategoryChildFromId(categoryId);
                iNav_view.onSetFragment(child.getTypeFragment());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onClickSetFragment(int type) {
        iNav_view.onSetFragment(type);
    }

    private void initilizeData() {
        database.dao().deleteCategory();
        childDatabase.dao().deleteCategoryChild();
        Log.w("NavPresenter", "initilizeData: " + database.dao().getAllCategory().size() + " " +
                childDatabase.dao().getAllCategoryChild().size());
//        if (database.dao().getAllCategory() == null || database.dao().getAllCategory().size() == 0) {
        if (database.dao().getAll() == null || database.dao().getAll().size() == 0) {
            database.dao().addCategory(new Category("Yêu thích", "Favorites", TYPE_DATABASE_TITLE, 0, false));
            database.dao().addCategory(new Category("Tính năng", "Features", TYPE_DATABASE_TITLE, 0, false));
            database.dao().addCategory(new Category("Thành viên", "Member", TYPE_DATABASE_TITLE, 0, false));
            database.dao().addCategory(new Category("Trợ giúp", "Help", TYPE_DATABASE_TITLE, 0, false));

            database.dao().addCategory(new Category("Trang chủ", "Home", TYPE_DATABASE_FEATURES, TYPE_MENU_HOME, false));
            database.dao().addCategory(new Category("Tổng quan thị trường", "MarketData Overview", TYPE_DATABASE_FEATURES, TYPE_MENU_MARKET_OVERRVIEW, false));
            database.dao().addCategory(new Category("Bảng giá", "Watchlist", TYPE_DATABASE_FEATURES, TYPE_MENU_WATCHLIST, false));
            database.dao().addCategory(new Category("Tin tức", "News", TYPE_DATABASE_FEATURES, TYPE_MENU_NEWS, false));
            database.dao().addCategory(new Category("Lịch sự kiện", "Events", TYPE_DATABASE_FEATURES, TYPE_MENU_EVENTS, false));
            database.dao().addCategory(new Category("Biểu đồ", "Chart", TYPE_DATABASE_FEATURES, TYPE_MENU_CHART, false));
            database.dao().addCategory(new Category("Chỉ số thế giới", "World Indexes", TYPE_DATABASE_FEATURES, TYPE_MENU_WORLD_INDEX, false));

            database.dao().addCategory(new Category("Đặt lệnh", "Place Orders", TYPE_DATABASE_MEMBER, MENU_DAT_LENH, false));
            database.dao().addCategory(new Category("Báo cáo tài sản", "Asset Report", TYPE_DATABASE_MEMBER, MENU_BAO_CAO_TAI_SAN, false));
            database.dao().addCategory(new Category("Lịch sử ứng trước", "Advance Report", TYPE_DATABASE_MEMBER, MENU_LICH_SU_UNG_TRUOC, false));

            database.dao().addCategory(new Category("Mở tài khoản", "Create Account", TYPE_DATABASE_HELP, MENU_MO_TAI_KHOAN, false));
            database.dao().addCategory(new Category("Liên hệ", "Contact", TYPE_DATABASE_HELP, MENU_LIEN_HE, false));
            database.dao().addCategory(new Category("Góp ý", "Feedback", TYPE_DATABASE_HELP, MENU_GOP_Y, false));
            database.dao().addCategory(new Category("Hướng dẫn sử dụng", "Guide", TYPE_DATABASE_HELP, MENU_HUONG_DAN_SU_DUNG, false));

        }
    }
}
