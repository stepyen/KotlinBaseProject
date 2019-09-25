package com.stepyen.kotlinbaseproject.mvp.presenter

import android.app.Application

import com.stepyen.xframe.integration.AppManager
import com.stepyen.xframe.di.scope.FragmentScope
import com.stepyen.xframe.mvp.BasePresenter
import com.stepyen.xframe.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.stepyen.kotlinbaseproject.mvp.contract.HomeContract


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@FragmentScope
class HomePresenter
@Inject
constructor(model: HomeContract.Model, rootView: HomeContract.View) :
    BasePresenter<HomeContract.Model, HomeContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager


    override fun onDestroy() {
        super.onDestroy();
    }
}
