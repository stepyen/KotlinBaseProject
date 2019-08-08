package com.stepyen.kotlinbaseproject.di.component

import dagger.Component
import com.stepyen.xframe.di.component.AppComponent

import com.stepyen.kotlinbaseproject.di.module.TestModule

import com.stepyen.xframe.di.scope.ActivityScope
import com.stepyen.kotlinbaseproject.mvp.ui.activity.TestActivity


/**
 * date：08/08/2019
 * author：stepyen
 * description：
 */
@ActivityScope
@Component(modules = arrayOf(TestModule::class), dependencies = arrayOf(AppComponent::class))
interface TestComponent {
    fun inject(activity: TestActivity)
}