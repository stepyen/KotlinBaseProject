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

    public void postTask(Runnable task) {
        mHandler.post(task);
    }

    public void postTaskDelay(Runnable task, long delayMillis) {
        mHandler.postDelayed(task, delayMillis);
    }

    public void removeTask(Runnable task) {
        mHandler.removeCallbacks(task);
    }
}
