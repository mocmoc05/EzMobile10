package com.trang.ez_mobile.view.news.detail;

/**
 * Created by TraPTH on 2/22/2018.
 */

public interface NewsDetailInterface {
    interface View {
        void dataDetailDone(String title, String lead, String body);

        void dataFail();

        void onLoad();

        void connectFail();

        void moveFragment(String id, String img, String folder);

        void connectServerFail();
    }

    interface Presenter {
        void callData(String id, String folder);
    }

}
