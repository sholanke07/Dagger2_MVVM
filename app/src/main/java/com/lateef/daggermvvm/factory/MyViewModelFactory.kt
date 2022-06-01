package com.lateef.daggermvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lateef.daggermvvm.viewmodel.MyViewModel
import dagger.Provides
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
//@Target(AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD)
class MyViewModelFactory @Inject constructor(private val myViewModelProvider: Provider<MyViewModel>): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return myViewModelProvider.get() as T
    }
}