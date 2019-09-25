package com.stepyen.kotlinbaseproject.di.component

import dagger.Component
import com.stepyen.xframe.di.component.AppComponent

import com.stepyen.kotlinbaseproject.di.module.MineModule

import com.stepyen.xframe.di.scope.FragmentScope
import com.stepyen.kotlinbaseproject.mvp.ui.fragment.MineFragment


/**
 * date：09/25/2019
 * author：stepyen
 * description：
 */
@FragmentScope
@Component(modules = arrayOf(MineModule::class), dependencies = arrayOf(AppComponent::class))
interface MineComponent {
    fun inject(fragment: MineFragment)
}