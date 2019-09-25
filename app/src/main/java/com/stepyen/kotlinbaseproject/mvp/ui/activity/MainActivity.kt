package com.stepyen.kotlinbaseproject.mvp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.commonsdk.base.AppBaseActivity
import com.stepyen.commonsdk.constant.RouterHub
import com.stepyen.xframe.di.component.AppComponent
import com.stepyen.xui.widget.actionbar.TitleBar

import com.stepyen.kotlinbaseproject.di.component.DaggerMainComponent
import com.stepyen.kotlinbaseproject.di.module.MainModule
import com.stepyen.kotlinbaseproject.mvp.contract.MainContract
import com.stepyen.kotlinbaseproject.mvp.presenter.MainPresenter

import com.stepyen.kotlinbaseproject.R
import com.stepyen.kotlinbaseproject.mvp.ui.fragment.HomeFragment
import com.stepyen.kotlinbaseproject.mvp.ui.fragment.MineFragment
import com.stepyen.xframe.base.BaseFragmentContentAdapter
import com.stepyen.xui.utils.ResUtils
import com.stepyen.xui.widget.tabbar.TabSegment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@Route(path = RouterHub.MainActivity)
class MainActivity : AppBaseActivity<MainPresenter>(), MainContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .mainModule(MainModule(this))
            .build()
            .inject(this)
    }

    override fun initTitleBar(): View? {
        return super.initTitleBar() as TitleBar
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun initData(@Nullable savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        initTabs()
        val adapter = BaseFragmentContentAdapter(supportFragmentManager, getFragments())
        vp_main.setAdapter(adapter)
        tabs_main.setupWithViewPager(vp_main, false)

    }

    override fun onLoad() {

    }

    private fun initTabs() {

        tabs_main.addTab(
            TabSegment.Tab("首页")
        )
        tabs_main.addTab(
            TabSegment.Tab("我的")
        )

    }

    private fun getFragments(): ArrayList<Fragment> {
        val fragments = ArrayList<Fragment>()
        fragments.add(HomeFragment.newInstance())
        fragments.add(MineFragment.newInstance())
        return fragments
    }
}





