package com.lateef.daggermvvm.BindingMultiplyDaggerMVVM.BindingViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lateef.daggermvvm.BindingMultiplyDaggerMVVM.BindingRepository.BindingRepository1
import com.lateef.daggermvvm.BindingMultiplyDaggerMVVM.BindingRepository.BindingRepository2
import javax.inject.Inject

class BindingViewModel2: ViewModel {

    @Inject
    constructor()
    var repository2 = BindingRepository2()
    var mutableLiveData = MutableLiveData<String>()

    fun callData(){
        repository2.getMutableLiveData()
    }

    fun getMutableLiveDataString(): MutableLiveData<String> {
        mutableLiveData = repository2.getMutableLiveDataString()
        return mutableLiveData
    }

}