package com.example.fragmentproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val messageFragment1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageFragment2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageFragment3: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}