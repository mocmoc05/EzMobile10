package com.trang.ez_mobile;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;


public class App extends MultiDexApplication {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        Stetho.initializeWithDefaults(this);
//        Db.init(this);
        MultiDex.install(this);

        configCrash();
    }

    private void configCrash() {
//        CaocConfig.Builder.create()
//                .errorActivity(CrashActivity.class)
//                .showErrorDetails(true)
//                .showRestartButton(true)
//                .trackActivities(true)
//                .minTimeBetweenCrashesMs(3000)
//                .apply();
    }

}
