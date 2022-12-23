package com.example.fragmentproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.fragmentproject.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    val firstTag = "fragment1Tag"
    val secondTag = "fragment2Tag"
    val thirdTag = "fragment3Tag"
    val fourthTag = "fragment4Tag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeholder, Fragment1.newInstance(), firstTag)
//          .addToBackStack(null) чтобы приложение закрывалось на нём
            .commit()
        binding.firstButtonFrag.setOnClickListener {
            backListener(firstTag,1, fragmentManager = supportFragmentManager)
        }

    }
//        fun createNewButton(text: String) : Button{
//        val button = Button(this)
//        val mainLayout = binding.linearLayoutMain
//        button.layoutParams = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.WRAP_CONTENT,
//            LinearLayout.LayoutParams.WRAP_CONTENT
//        )
//        button.text = text
//        mainLayout.addView(button)
//        return button
//    }

    fun createNewMaterialButton(text: String) : MaterialButton { //ладно
        val button = MaterialButton(this)
        val mainLayout = binding.linearLayoutMain
        button.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        button.text = text
        mainLayout.addView(button)
        return button
    }

    override fun onBackPressed() {

        val count = supportFragmentManager.backStackEntryCount
        if(count == 0){
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}