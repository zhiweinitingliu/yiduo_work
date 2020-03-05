package com.wang.yiduo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.baidu.mobstat.StatService;


public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

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

        String testDeviceId = StatService.getTestDeviceId(this);
        Log.e(TAG, "" + testDeviceId);
        StatService.start(this);


        PushUtil.getInstance().init(this);
    }
}
