package com.wang.yiduo;

import android.app.Application;

import com.wang.push.PushUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        PushUtil.getInstance().init(this);
    }
}
