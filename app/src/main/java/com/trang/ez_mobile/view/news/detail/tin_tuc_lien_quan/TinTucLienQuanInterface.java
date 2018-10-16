package com.trang.ez_mobile.view.news.detail.tin_tuc_lien_quan;

import java.util.List;

/**
 * Created by TraPTH on 2/22/2018.
 */

public interface TinTucLienQuanInterface {
    interface Presenter {
        void getData(String folder, String id);
    }

    interface View {

        void dataTinLienQuanDone(List<TinTucLienQuan> tinTucList);

        void dataFail();

        void onLoad();

        void connectFail();

        void connectServerFail();
    }
}
