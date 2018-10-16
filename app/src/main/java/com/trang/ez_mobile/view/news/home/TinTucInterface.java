package com.trang.ez_mobile.view.news.home;

import java.util.List;

/**
 * Created by TraPTH on 2/22/2018.
 */

public interface TinTucInterface {
    interface View {
        void getDataDone(List<TinTuc> tinTucList, String folder);

        void getDataFail();

        void onLoad();

        void connectFail();

        void moveFragmentView(String id, String img, String folder);

        void connectServerFail();
    }

    interface Presenter {
        void getData();
    }
}
