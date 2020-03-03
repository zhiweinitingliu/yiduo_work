package com.wang.push;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import com.huawei.hms.aaid.HmsInstanceId;
import com.wang.push.enums.ManuFacturerEnum;
import com.wang.push.listener.MessageReceiver;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description :
 * @Author : wdk
 * @CretaTime : 2020/3/1 16:23
 * @LastModify(最终修改人) :wdk
 * @LastModifyTime(最终修改时间) : 2020/3/1 16:23
 * @LastCheckBy :wdk
 */
public class PushManager {
    private static final PushManager ourInstance = new PushManager();

    public static PushManager getInstance() {
        return ourInstance;
    }

    private PushManager() {

    }

    public MessageReceiver messageReceiver;

    public void init(Application application, MessageReceiver messageReceiver) {
        this.messageReceiver = messageReceiver;
        //获取判断手机制造商，初始化推送
        ManuFacturerEnum manufacturer = ManuFacturerEnum.getManufacturer();
        switch (manufacturer) {
            case HUAWEI:
                huaweiInit(application);
                break;
        }
    }

    private void huaweiInit(Application application) {
        //初始化华为配置
        AGConnectServicesConfig agConnectServicesConfig = AGConnectServicesConfig.fromContext(application);
        agConnectServicesConfig.overlayWith(new LazyInputStream(application) {
            public InputStream get(Context context) {
                try {
                    return context.getAssets().open("agconnect-services.json");
                } catch (IOException e) {
                    return null;
                }
            }
        });
        HmsInstanceId hmsInstanceId = HmsInstanceId.getInstance(application);
        getHuaweiToken(agConnectServicesConfig, hmsInstanceId);
    }

    public void getHuaweiToken(final AGConnectServicesConfig agConnectServicesConfig, final HmsInstanceId hmsInstanceId) {
        // get token
        new Thread() {
            @Override
            public void run() {
                try {
                    String appId = agConnectServicesConfig.getString("client/app_id");
                    String pushtoken = hmsInstanceId.getToken(appId, "HCM");
                    if (!TextUtils.isEmpty(pushtoken)) {
                        messageReceiver.onGetToken(pushtoken);
                    }
                } catch (Exception e) {
                }
            }
        }.start();
    }

}
