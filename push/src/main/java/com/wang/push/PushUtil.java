package com.wang.push;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;

/**
 * @Description :
 * @Author : wdk
 * @CretaTime : 2020/2/23 16:57
 * @LastModify(最终修改人) :wdk
 * @LastModifyTime(最终修改时间) : 2020/2/23 16:57
 * @LastCheckBy :wdk
 */
public class PushUtil {

    private static final String TAG = "PushUtil";

    private static final PushUtil ourInstance = new PushUtil();

    public static PushUtil getInstance() {
        return ourInstance;
    }

    private PushUtil() {

    }

    public void init(Application application) {

    }

    public void getToken(final Context context) {
        Log.i(TAG, "get token: begin");

        // get token
        new Thread() {
            @Override
            public void run() {
                Log.i(TAG, "get token: begin 2");

                try {
                    String appId = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
                    Log.i(TAG, "get token: appId  " + appId);
                    String pushtoken = HmsInstanceId.getInstance(context).getToken(appId, "HCM");
                    if (!TextUtils.isEmpty(pushtoken)) {
                        Log.i(TAG, "get token:" + pushtoken);

                    } else {
                        Log.i(TAG, "get token: is empty");
                    }
                } catch (Exception e) {
                    Log.i(TAG, "getToken failed, " + e);

                }
            }
        }.start();
    }
}
