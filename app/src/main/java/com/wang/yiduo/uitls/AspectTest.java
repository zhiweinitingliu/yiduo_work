package com.wang.yiduo.uitls;

import android.nfc.Tag;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @Description :
 * @Author : wdk
 * @CretaTime : 2020/2/27 14:09
 * @LastModify(最终修改人) :wdk
 * @LastModifyTime(最终修改时间) : 2020/2/27 14:09
 * @LastCheckBy :wdk
 */
@Aspect
public class AspectTest {

    private static final String TAG = "AspectTest";


    @Pointcut("execution(@com.wang.yiduo.uitls.SingleClick * *(..))")
    public void onBtnClickAfter() {

    }


    @Around("onBtnClickAfter()")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG,"切刀了click");

//
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//
//
//        String signatureStr = joinPoint.getSignature().toString();
//        Log.e(TAG, signatureStr + " --> aspectTest");
//
    }

}