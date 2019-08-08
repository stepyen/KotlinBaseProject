package com.stepyen.commonsdk.core;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import com.alibaba.android.arouter.launcher.ARouter;
import com.billy.android.loading.Gloading;
import com.stepyen.commonsdk.BuildConfig;
import com.stepyen.commonsdk.gloading.GlobalAdapter;
import com.stepyen.commonsdk.update.OKHttpUpdateHttpService;
import com.stepyen.xframe.base.delegate.AppLifecycles;
import com.stepyen.xui.XUI;
import com.stepyen.xutil.XUtil;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.UpdateError;
import com.xuexiang.xupdate.listener.OnUpdateFailureListener;

import java.util.Timer;

import butterknife.ButterKnife;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import timber.log.Timber;

/**
 * date：2019/6/21
 * author：stepyen
 * description：app sh
 */
public class AppLifecyclesImpl implements AppLifecycles {
    @Override
    public void attachBaseContext(@NonNull Context base) {

    }

    @Override
    public void onCreate(@NonNull Application application) {
        if (BuildConfig.LOG_DEBUG) {//Timber日志打印
            Timber.plant(new Timber.DebugTree());
            ButterKnife.setDebug(true);
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            RetrofitUrlManager.getInstance().setDebug(true);
            Gloading.debug(BuildConfig.DEBUG);
            XUI.debug(true);  //开启UI框架调试日志
        }
        ARouter.init(application); // 尽可能早,推荐在Application中初始化
        Gloading.initDefault(new GlobalAdapter());
        XUI.init(application);
        XUtil.init(application);

//        initUpdate(application);
    }

    @Override
    public void onTerminate(@NonNull Application application) {

    }


    private void initUpdate( Application application) {
        XUpdate.get()
                .debug(true)
                .isWifiOnly(false)                                               //默认设置只在wifi下检查版本更新
                .isGet(true)                                                    //默认设置使用get请求检查版本
                .isAutoMode(false)                                              //默认设置非自动模式，可根据具体使用配置
                .setOnUpdateFailureListener(new OnUpdateFailureListener() {     //设置版本更新出错的监听
                    @Override
                    public void onFailure(UpdateError error) {
//                        if (error.getCode() != CHECK_NO_NEW_VERSION) {          //对不同错误进行处理
//                            ToastUtils.toast(error.toString());
//                        }
                    }
                })
                .supportSilentInstall(true)                                     //设置是否支持静默安装，默认是true
                .setIUpdateHttpService(new OKHttpUpdateHttpService())           //这个必须设置！实现网络请求功能。
                .init(application);                                                    //这个必须初始化
    }
}
