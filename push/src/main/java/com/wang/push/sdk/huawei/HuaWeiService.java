package com.wang.push.sdk.huawei;

import android.util.Log;

import com.huawei.hms.push.HmsMessageService;
import com.wang.push.PushManager;

/**
 * @Description :
 * @Author : wdk
 * @CretaTime : 2020/2/23 14:57
 * @LastModify(最终修改人) :wdk
 * @LastModifyTime(最终修改时间) : 2020/2/23 14:57
 * @LastCheckBy :wdk
 */
public class HuaWeiService extends HmsMessageService {

    private static final String TAG = "HuaWeiService";

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        PushManager.getInstance().messageReceiver.onGetToken(s);
    }
}
