package com.wang.yiduo;

import android.app.Application;
import android.content.Context;


public class MyApplication extends Application {

    private static MyApplication context;

    public static Context getApplication() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        init();
    }

    private void init() {
        PushUtil.getInstance().init(this);
    }
}
