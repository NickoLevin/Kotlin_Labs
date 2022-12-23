package com.example.fragmentapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val fullSet = LinkedHashSet<String>()
    val message: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    public fun addToList(line: String){
        fullSet.add(line)
        Log.d("Tag","Добавили запись в список $line")
    }
}