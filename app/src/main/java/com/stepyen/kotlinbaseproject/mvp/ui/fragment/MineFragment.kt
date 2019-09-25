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

import com.stepyen.kotlinbaseproject.di.component.DaggerMineComponent
import com.stepyen.kotlinbaseproject.mvp.contract.MineContract
import com.stepyen.kotlinbaseproject.mvp.presenter.MinePresenter
import com.stepyen.kotlinbaseproject.di.module.MineModule

import com.stepyen.kotlinbaseproject.R


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
class MineFragment : AppBaseFragment<MinePresenter>(), MineContract.View {
    companion object {
        fun newInstance(): MineFragment {
            val fragment = MineFragment()
            return fragment
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerMineComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .mineModule(MineModule(this))
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
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
    }

    override fun onLoad() {

    }


    override fun setData(data: Any?) {

    }
}

