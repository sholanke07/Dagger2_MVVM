package com.lateef.daggermvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lateef.daggermvvm.repository.Repository
import javax.inject.Inject

class MyViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    var resultdata = MutableLiveData<String>()

    fun getDataViewModel(): String{

        val mydaggername = repository.getData()
        return mydaggername
    }

    fun callLiveData(){
        repository.getMyMutableData()
    }

    fun getMyLiveData(): MutableLiveData<String>{
        resultdata = repository.getMyLiveData()
        return resultdata

    }
}
