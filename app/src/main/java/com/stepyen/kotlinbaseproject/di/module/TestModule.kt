package com.stepyen.kotlinbaseproject.di.module

import com.stepyen.xframe.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.stepyen.kotlinbaseproject.mvp.contract.TestContract
import com.stepyen.kotlinbaseproject.mvp.model.TestModel


/**
 * date：08/08/2019
 * author：stepyen
 * description：
 */
@Module
//构建TestModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class TestModule(private val view: TestContract.View) {
    @ActivityScope
    @Provides
    fun provideTestView(): TestContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideTestModel(model: TestModel): TestContract.Model {
        return model
    }
}