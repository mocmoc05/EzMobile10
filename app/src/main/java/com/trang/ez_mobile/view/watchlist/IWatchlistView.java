package com.trang.ez_mobile.view.watchlist;

import com.bin.david.form.data.table.TableData;
import com.trang.ez_mobile.view.watchlist.model.Price;

/**
 * Created by FIT-thuctap22 on 3/22/2018.
 */

public interface IWatchlistView {
    void displayTable(TableData<Price> tableData);

    void moveFragment(String symbol, String color, String name, String code);

    void loading();

    void loadSuccess();
}