package com.example.fragmentapplication

import android.os.AsyncTask
import android.os.AsyncTask.execute
import android.util.Log

class DoAsync(dataModel: DataModel) : AsyncTask<Void, Void, Void>() {
        var dataModel: DataModel = dataModel
        var index = 0
    init {
        execute()
    }

    override fun doInBackground(vararg params: Void?): Void? {
        kotlin.run{
            while(!isCancelled) {

                Thread.sleep(2000)

                index++

                dataModel.message.postValue("Строка $index")
            }
        }
        return null
    }


}