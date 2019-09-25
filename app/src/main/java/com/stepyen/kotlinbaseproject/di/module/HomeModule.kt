package com.stepyen.kotlinbaseproject.di.module

import com.stepyen.xframe.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.stepyen.kotlinbaseproject.mvp.contract.HomeContract
import com.stepyen.kotlinbaseproject.mvp.model.HomeModel


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@Module
//构建HomeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class HomeModule(private val view: HomeContract.View) {
    @FragmentScope
    @Provides
    fun provideHomeView(): HomeContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideHomeModel(model: HomeModel): HomeContract.Model {
        return model
    }
}