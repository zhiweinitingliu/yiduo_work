package com.wang.yiduo;

import android.app.Application;

import com.wang.push.PushManager;

/**
 * @Description :
 * @Author : wdk
 * @CretaTime : 2020/3/2 18:45
 * @LastModify(最终修改人) :wdk
 * @LastModifyTime(最终修改时间) : 2020/3/2 18:45
 * @LastCheckBy :wdk
 */
public class PushUtil {
    private static final PushUtil ourInstance = new PushUtil();

    public static PushUtil getInstance() {
        return ourInstance;
    }

    private PushUtil() {
    }

    public void init(Application application){
        PushManager.getInstance().init(application,new PushMessageReceiveImpl());
    }
}
