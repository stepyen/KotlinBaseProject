package com.stepyen.kotlinbaseproject.di.module

import com.stepyen.xframe.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.stepyen.kotlinbaseproject.mvp.contract.LoginContract
import com.stepyen.kotlinbaseproject.mvp.model.LoginModel


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@Module
//构建LoginModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class LoginModule(private val view: LoginContract.View) {
    @ActivityScope
    @Provides
    fun provideLoginView(): LoginContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideLoginModel(model: LoginModel): LoginContract.Model {
        return model
    }
}