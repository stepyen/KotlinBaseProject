package com.stepyen.commonsdk.utils;

import android.os.Handler;
import android.os.Looper;

public class HandlerUtil {

    private static volatile HandlerUtil instance;
    private static Handler mHandler;
    private HandlerUtil() {
        mHandler = new Handler(Looper.getMainLooper());
    }
    public static HandlerUtil getInstance() {
        if (instance == null) {
            synchronized (HandlerUtil.class) {
                if (instance == null) {
                    instance = new HandlerUtil();
                }
            }
        }
        return instance;
    }

    public static void postTask(Runnable task) {
        getInstance().mHandler.post(task);
    }

    public static void postTaskDelay( long delayMillis,Runnable task) {
        getInstance().mHandler.postDelayed(task, delayMillis);
    }

    public static void removeTask(Runnable task) {
        getInstance().mHandler.removeCallbacks(task);
    }
}
