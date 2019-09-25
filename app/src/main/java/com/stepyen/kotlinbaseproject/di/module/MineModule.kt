package com.stepyen.kotlinbaseproject.di.module

import com.stepyen.xframe.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.stepyen.kotlinbaseproject.mvp.contract.MineContract
import com.stepyen.kotlinbaseproject.mvp.model.MineModel


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@Module
//构建MineModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MineModule(private val view: MineContract.View) {
    @FragmentScope
    @Provides
    fun provideMineView(): MineContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideMineModel(model: MineModel): MineContract.Model {
        return model
    }
}