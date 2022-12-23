package com.example.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val adapter = LineAdapter()
    private val dataModel: DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var doAsync: DoAsync = DoAsync(dataModel)

        dataModel.message.observe(this){
            if(!dataModel.fullSet.contains(it)){
                adapter.addLine(it)
                dataModel.addToList(it)
            }

        }
        init()
        val recyclerView : RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        binding.mainButton.setOnClickListener {
            doAsync.cancel(true)
        }

    }
    private fun init(){
        binding.apply{
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
            adapter.addAll(dataModel.fullSet)
        }
    }
}