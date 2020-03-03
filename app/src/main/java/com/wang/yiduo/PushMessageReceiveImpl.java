package com.wang.yiduo;

import android.widget.Toast;

import com.wang.push.listener.MessageReceiver;

/**
 * @Description :
 * @Author : wdk
 * @CretaTime : 2020/3/2 18:51
 * @LastModify(最终修改人) :wdk
 * @LastModifyTime(最终修改时间) : 2020/3/2 18:51
 * @LastCheckBy :wdk
 */
public class PushMessageReceiveImpl implements MessageReceiver {

    @Override
    public void onReceive() {

    }

    @Override
    public void onGetToken(String token) {
        Toast.makeText(MyApplication.getApplication(), token, Toast.LENGTH_LONG).show();
    }
}
