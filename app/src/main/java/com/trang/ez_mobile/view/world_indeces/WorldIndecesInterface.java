package com.trang.ez_mobile.view.world_indeces;

import java.util.List;

/**
 * Created by TraPTH on 3/16/2018.
 */

public interface WorldIndecesInterface {
    interface View {
        void dataDone(List<WorldIndeces> worldIndecesList);

        void dataFail();

        void onLoad();

        void connectFail();

        void connectServerFail();
    }

    interface Presenter {
        void callData();
    }
}
