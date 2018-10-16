package com.trang.ez_mobile.view.home;

import android.util.SparseArray;

import com.trang.ez_mobile.model.entity.CodeStockWatchList;
import com.trang.ez_mobile.model.entity.NewsArticle;
import com.trang.ez_mobile.model.entity.StockMarket;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.view.home.custormHome.BigGroup;

import java.util.ArrayList;
import java.util.List;

public interface IHomeView {

    void onLoading();

    void onDisplay(SparseArray<BigGroup> sparseArray);
    //ArrayList<ItemHeaderHome> listGroup, ArrayList<ItemHomeChild> listDataChild);
//                    HashMap<IItemHomeInterface, ArrayList<IItemHomeInterface>> listDataChild);

    interface IBiggroupCallBack {

        void onReplaceFragment(String marketCode, int type);

        void onReplaceFragment(int typeItem, Define.HOME_TYPE_ACTION typeAction);
    }

    interface IAdapterCallback {
        void onReplaceFragment(String marketCode);
    }

    interface IBigGroupView {
        void onDisplay(List<StockMarket> stockMarkets);

        void onError(ErrorApp error);
    }
}
