package com.lateef.daggermvvm.BindingMultiplyDaggerMVVM.BindingRepository

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class BindingRepository2 {

    @Inject
    constructor()
    var mutableLiveData = MutableLiveData<String>()

    fun getMutableLiveData(){
        mutableLiveData.value = "This is repository2 "
    }

    fun getMutableLiveDataString(): MutableLiveData<String> {
        return mutableLiveData
    }
}