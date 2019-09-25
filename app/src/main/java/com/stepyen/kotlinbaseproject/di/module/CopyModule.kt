package com.stepyen.kotlinbaseproject.di.module

import com.stepyen.xframe.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.stepyen.kotlinbaseproject.mvp.contract.CopyContract
import com.stepyen.kotlinbaseproject.mvp.model.CopyModel


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@Module
//构建CopyModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class CopyModule(private val view: CopyContract.View) {
    @ActivityScope
    @Provides
    fun provideCopyView(): CopyContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideCopyModel(model: CopyModel): CopyContract.Model {
        return model
    }
}