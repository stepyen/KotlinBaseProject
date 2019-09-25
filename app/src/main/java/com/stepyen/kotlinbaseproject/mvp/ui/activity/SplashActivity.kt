package com.stepyen.kotlinbaseproject.mvp.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.commonsdk.constant.RouterHub
import com.stepyen.kotlinbaseproject.util.navigation
import com.stepyen.xui.activity.BaseSplashActivity

/**
 * date：2019/9/25
 * author：stepyen
 * description：
 *
 */
@Route(path = RouterHub.SplashActivity)
class SplashActivity : BaseSplashActivity() {
    override fun onCreateActivity() {
        startSplash(true)
    }

    override fun onSplashFinished() {
        navigation(RouterHub.LoginActivity)
        finish()
    }
}