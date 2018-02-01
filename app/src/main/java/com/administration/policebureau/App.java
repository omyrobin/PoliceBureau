package com.administration.policebureau;

import android.app.Application;

/**
 * Created by omyrobin on 2018/1/14.
 */

public class App extends Application {

    //用来判断是否被强杀的状态标识
    public static int mAppStatus = -1;
    private static App mApp;

    public static App getInstance(){
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

}
