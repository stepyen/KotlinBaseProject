/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stepyen.commonsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;

import android.view.TouchDelegate;
import android.view.View;


import com.alibaba.android.arouter.launcher.ARouter;
import com.stepyen.commonsdk.entity.User;
import com.stepyen.commonsdk.manager.SPManager;
import com.stepyen.commonsdk.manager.UserManager;
import com.stepyen.xui.XUI;
import com.stepyen.xutil.data.BaseSPUtil;

import java.util.List;

/**
 *
 *
 * 通用工具类
 */
public class CommonUtils {
    private CommonUtils() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    /**
     * 使用 {@link ARouter} 根据 {@code path} 跳转到对应的页面, 这个方法因为没有使用 {@link Activity}跳转
     * 所以 {@link ARouter} 会自动给 {@link android.content.Intent} 加上 Intent.FLAG_ACTIVITY_NEW_TASK
     * 如果不想自动加上这个 Flag 请使用 {@link ARouter#getInstance()#navigation(Context, String)} 并传入 {@link Activity}
     *
     * @param path {@code path}
     */
    public static void navigation(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    /**
     * 使用 {@link ARouter} 根据 {@code path} 跳转到对应的页面, 如果参数 {@code context} 传入的不是 {@link Activity}
     * {@link ARouter} 就会自动给 {@link android.content.Intent} 加上 Intent.FLAG_ACTIVITY_NEW_TASK
     * 如果不想自动加上这个 Flag 请使用 {@link Activity} 作为 {@code context} 传入
     *
     * @param context
     * @param path
     */
    public static void navigation(Context context, String path) {
        ARouter.getInstance().build(path).navigation(context);
    }


    public static BaseSPUtil getSP() {
        return SPManager.getSP();
    }

    public static User getUser() {
        return UserManager.getInstance().getUser();
    }


    public static String getUserid() {
        return getUser().getUserId();
    }

    public static boolean isNoEmpty(List list) {
        if (list == null ||list.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * 增加View的点击区域
     * @param view
     */
    public static void expandTouchArea(View view) {
        expandTouchArea(view, 20);
    }

    public static void expandTouchArea(View view, int size) {
        View parentView = (View) view.getParent();
        parentView.post(new Runnable() {
            @Override
            public void run() {
                Rect rect = new Rect();
                view.getHitRect(rect);

                rect.top -= size;
                rect.bottom += size;
                rect.left -= size;
                rect.right += size;

                parentView.setTouchDelegate(new TouchDelegate(rect, view));
            }
        });
    }
}
