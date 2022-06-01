package com.lateef.daggermvvm.di

import com.lateef.daggermvvm.MainActivity
import com.lateef.daggermvvm.MyModule
import dagger.Component

@Component (modules = [MyModule::class])
interface MyComponent {

    fun inject (activity: MainActivity)
}