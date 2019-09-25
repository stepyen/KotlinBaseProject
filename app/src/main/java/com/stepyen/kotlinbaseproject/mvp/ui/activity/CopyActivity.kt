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

import com.stepyen.kotlinbaseproject.di.component.DaggerCopyComponent
import com.stepyen.kotlinbaseproject.di.module.CopyModule
import com.stepyen.kotlinbaseproject.mvp.contract.CopyContract
import com.stepyen.kotlinbaseproject.mvp.presenter.CopyPresenter

import com.stepyen.kotlinbaseproject.R


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@Route(path = RouterHub.CopyActivity)
class CopyActivity : AppBaseActivity<CopyPresenter>(), CopyContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerCopyComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .copyModule(CopyModule(this))
            .build()
            .inject(this)
    }

    override fun initTitleBar(): View? {
        return super.initTitleBar() as TitleBar
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_copy
    }


    override fun initData(@Nullable savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

    }

    override fun onLoad() {

    }
}





