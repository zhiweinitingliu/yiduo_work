package com.wang.push.listener;

/**
 * @Description :
 * @Author : wdk
 * @CretaTime : 2020/3/1 16:23
 * @LastModify(最终修改人) :wdk
 * @LastModifyTime(最终修改时间) : 2020/3/1 16:23
 * @LastCheckBy :wdk
 */
public interface MessageReceiver {


    void onReceive();

    void onGetToken(String token);


}
