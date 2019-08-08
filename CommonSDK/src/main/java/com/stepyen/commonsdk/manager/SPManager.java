package com.stepyen.commonsdk.manager;

import com.stepyen.xui.XUI;
import com.stepyen.xutil.data.BaseSPUtil;

/**
 * date：2019-07-05
 * author：stepyen
 * description：
 */
public class SPManager {
    /**
     * sp 文件名
     */
    private static final String APP_SP_NAME = "app_sp";

    private BaseSPUtil mBaseSPUtil;

    private static volatile SPManager instance;

    private SPManager() {
        mBaseSPUtil = new BaseSPUtil(XUI.getContext(), APP_SP_NAME);
    }
    public static SPManager getInstance() {
        if (instance == null) {
            synchronized (SPManager.class) {
                if (instance == null) {
                    instance = new SPManager();
                }
            }
        }
        return instance;
    }

    public static BaseSPUtil getSP() {
        return getInstance().mBaseSPUtil;
    }


}
