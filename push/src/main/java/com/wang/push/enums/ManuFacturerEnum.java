package com.wang.push.enums;

import android.os.Build;

/**
 * @Description : 制造商枚举类
 * @Author : wdk
 * @CretaTime : 2020/3/2 18:29
 * @LastModify(最终修改人) :wdk
 * @LastModifyTime(最终修改时间) : 2020/3/2 18:29
 * @LastCheckBy :wdk
 */
public enum ManuFacturerEnum {
    HUAWEI,XIAOMI,VIVO,OPPO,MEIZU,OTHER;

    public static ManuFacturerEnum getManufacturer() {
        //获取制造商名称
        String name = Build.MANUFACTURER;
        switch (name) {
            case "HUAWEI":
                return HUAWEI;
            case "Xiaomi":
                return XIAOMI;
            case "vivo":
                return VIVO;
            case "OPPO":
                return OPPO;
            case "Meizu":
                return MEIZU;
            default:
                return OTHER;
        }
    }
}
