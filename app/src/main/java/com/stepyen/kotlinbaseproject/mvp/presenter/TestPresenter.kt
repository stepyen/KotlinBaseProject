package com.stepyen.kotlinbaseproject.mvp.presenter

import android.app.Application

import com.stepyen.xframe.integration.AppManager
import com.stepyen.xframe.di.scope.ActivityScope
import com.stepyen.xframe.mvp.BasePresenter
import com.stepyen.xframe.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.stepyen.kotlinbaseproject.mvp.contract.TestContract


/**
 * date：08/08/2019
 * author：stepyen
 * description：
 */
@ActivityScope
class TestPresenter
@Inject
constructor(model: TestContract.Model, rootView: TestContract.View) :
    BasePresenter<TestContract.Model, TestContract.View>(model, rootView) {
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
