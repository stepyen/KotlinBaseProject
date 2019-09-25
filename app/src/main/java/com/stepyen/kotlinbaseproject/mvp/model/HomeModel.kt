package com.stepyen.kotlinbaseproject.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.stepyen.xframe.integration.IRepositoryManager
import com.stepyen.xframe.mvp.BaseModel
import javax.inject.Inject


import com.stepyen.xframe.di.scope.FragmentScope

import com.stepyen.kotlinbaseproject.mvp.contract.HomeContract


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@FragmentScope
class HomeModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager),
    HomeContract.Model {
    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
