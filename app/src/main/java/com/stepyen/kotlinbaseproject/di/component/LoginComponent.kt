package com.stepyen.kotlinbaseproject.di.component

import dagger.Component
import com.stepyen.xframe.di.component.AppComponent

import com.stepyen.kotlinbaseproject.di.module.LoginModule

import com.stepyen.xframe.di.scope.ActivityScope
import com.stepyen.kotlinbaseproject.mvp.ui.activity.LoginActivity


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@ActivityScope
@Component(modules = arrayOf(LoginModule::class), dependencies = arrayOf(AppComponent::class))
interface LoginComponent {
    fun inject(activity: LoginActivity)
}