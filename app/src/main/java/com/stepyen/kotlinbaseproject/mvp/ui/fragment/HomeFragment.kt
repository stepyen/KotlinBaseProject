package com.stepyen.kotlinbaseproject.mvp.ui.fragment

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepyen.commonsdk.base.AppBaseFragment;
import com.stepyen.xframe.di.component.AppComponent;
import com.stepyen.xui.widget.actionbar.TitleBar;

import com.stepyen.kotlinbaseproject.di.component.DaggerHomeComponent
import com.stepyen.kotlinbaseproject.mvp.contract.HomeContract
import com.stepyen.kotlinbaseproject.mvp.presenter.HomePresenter
import com.stepyen.kotlinbaseproject.di.module.HomeModule

import com.stepyen.kotlinbaseproject.R


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
class HomeFragment : AppBaseFragment<HomePresenter>(), HomeContract.View {
    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            return fragment
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerHomeComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .homeModule(HomeModule(this))
            .build()
            .inject(this)
    }

    override fun initTitleBar(): View? {
        return null
    }

    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
    }

    override fun onLoad() {

    }


    override fun setData(data: Any?) {

    }
}

