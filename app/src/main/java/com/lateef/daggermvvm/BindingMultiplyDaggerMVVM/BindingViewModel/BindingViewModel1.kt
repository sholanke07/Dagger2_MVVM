package com.lateef.daggermvvm.BindingMultiplyDaggerMVVM.BindingViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lateef.daggermvvm.BindingMultiplyDaggerMVVM.BindingRepository.BindingRepository1
import javax.inject.Inject

class BindingViewModel1: ViewModel {

    @Inject
    constructor()
    var repository1 = BindingRepository1()
    var mutableLiveData = MutableLiveData<String>()

    fun callData(){
        repository1.getMutableLiveData()
    }

    fun getMutableLiveDataString(): MutableLiveData<String>{
        mutableLiveData = repository1.getMutableLiveDataString()
        return mutableLiveData
    }

}