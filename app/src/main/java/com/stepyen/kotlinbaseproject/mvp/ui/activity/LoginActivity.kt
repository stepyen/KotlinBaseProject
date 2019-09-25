package com.stepyen.kotlinbaseproject.mvp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.commonsdk.base.AppBaseActivity
import com.stepyen.commonsdk.constant.RouterHub
import com.stepyen.xframe.di.component.AppComponent
import com.stepyen.xui.widget.actionbar.TitleBar

import com.stepyen.kotlinbaseproject.di.component.DaggerLoginComponent
import com.stepyen.kotlinbaseproject.di.module.LoginModule
import com.stepyen.kotlinbaseproject.mvp.contract.LoginContract
import com.stepyen.kotlinbaseproject.mvp.presenter.LoginPresenter

import com.stepyen.kotlinbaseproject.R


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@Route(path = RouterHub.LoginActivity)
class LoginActivity : AppBaseActivity<LoginPresenter>(), LoginContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .loginModule(LoginModule(this))
            .build()
            .inject(this)
    }

    override fun initTitleBar(): View? {
        return super.initTitleBar() as TitleBar
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }


    override fun initData(@Nullable savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

    }

    override fun onLoad() {

    }
}





