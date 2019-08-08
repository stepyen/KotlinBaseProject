package com.stepyen.commonsdk.constant;

import android.os.Environment;

public class SystemConst {

    //app类型 app端，0：IOS 1：Android
    public static String MT = "android";

    //基本路径
    public static String BASE_PATH = Environment.getExternalStorageDirectory() + "/stepyen/";
    //闪屏页图片路径
    public static String SPLASH_IMAGE_PATH = BASE_PATH + "splash/";
    //图片路径
    public static String TEMP_IMAGE_PATH = BASE_PATH + "image/";
    //安装包路径
    public static String TEMP_APK_PATH = BASE_PATH + "apk/";

    /**************************************** 第三方相关 ******************************************/


}
