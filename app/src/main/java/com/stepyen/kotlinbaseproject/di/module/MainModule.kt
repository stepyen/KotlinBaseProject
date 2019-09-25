package com.stepyen.kotlinbaseproject.di.module

import com.stepyen.xframe.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.stepyen.kotlinbaseproject.mvp.contract.MainContract
import com.stepyen.kotlinbaseproject.mvp.model.MainModel


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@Module
//构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MainModule(private val view: MainContract.View) {
    @ActivityScope
    @Provides
    fun provideMainView(): MainContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMainModel(model: MainModel): MainContract.Model {
        return model
    }
}