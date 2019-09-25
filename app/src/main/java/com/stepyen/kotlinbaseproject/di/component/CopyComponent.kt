package com.stepyen.kotlinbaseproject.di.component

import dagger.Component
import com.stepyen.xframe.di.component.AppComponent

import com.stepyen.kotlinbaseproject.di.module.CopyModule

import com.stepyen.xframe.di.scope.ActivityScope
import com.stepyen.kotlinbaseproject.mvp.ui.activity.CopyActivity


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@ActivityScope
@Component(modules = arrayOf(CopyModule::class), dependencies = arrayOf(AppComponent::class))
interface CopyComponent {
    fun inject(activity: CopyActivity)
}