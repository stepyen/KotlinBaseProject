package com.stepyen.kotlinbaseproject.mvp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import com.stepyen.commonsdk.base.AppBaseActivity
import com.stepyen.xframe.di.component.AppComponent
import com.stepyen.xui.widget.actionbar.TitleBar

import com.stepyen.kotlinbaseproject.di.component.DaggerTestComponent
import com.stepyen.kotlinbaseproject.di.module.TestModule
import com.stepyen.kotlinbaseproject.mvp.contract.TestContract
import com.stepyen.kotlinbaseproject.mvp.presenter.TestPresenter

import com.stepyen.kotlinbaseproject.R


/**
 * date：08/08/2019
 * author：stepyen
 * description：
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */

class TestActivity : AppBaseActivity<TestPresenter>(), TestContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerTestComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .testModule(TestModule(this))
            .build()
            .inject(this)
    }

    override fun initTitleBar(): View {
        return super.initTitleBar() as TitleBar
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_test
    }


    override fun initData(@Nullable savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

    }

    override fun onLoad() {

    }
}





