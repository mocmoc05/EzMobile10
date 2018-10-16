package com.trang.ez_mobile.view.watchlist.model;

import com.bin.david.form.data.Column;

/**
 * Created by FIT-thuctap22 on 2/1/2018.
 */

public class MixColumns {
    Column[] columns;

    public MixColumns(Column... columns) {
        this.columns = columns;
    }

    public Column[] getColumns() {
        return columns;
    }

    public void setColumns(Column... columns) {
        this.columns = columns;
    }
}
