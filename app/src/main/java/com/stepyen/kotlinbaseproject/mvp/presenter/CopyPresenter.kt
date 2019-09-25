package com.stepyen.kotlinbaseproject.mvp.presenter

import android.app.Application

import com.stepyen.xframe.integration.AppManager
import com.stepyen.xframe.di.scope.ActivityScope
import com.stepyen.xframe.mvp.BasePresenter
import com.stepyen.xframe.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.stepyen.kotlinbaseproject.mvp.contract.CopyContract


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@ActivityScope
class CopyPresenter
@Inject
constructor(model: CopyContract.Model, rootView: CopyContract.View) :
    BasePresenter<CopyContract.Model, CopyContract.View>(model, rootView) {
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
