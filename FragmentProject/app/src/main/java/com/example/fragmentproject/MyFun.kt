package com.example.fragmentproject

import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.button.MaterialButton

val firstTag = "fragment1Tag"
val secondTag = "fragment2Tag"
val thirdTag = "fragment3Tag"
val fourthTag = "fragment4Tag"
fun backListener(tag : String, type : Int, fragmentManager: FragmentManager){
    var fTransaction = fragmentManager.beginTransaction()
    var newFragment: Fragment? = fragmentManager.findFragmentByTag(tag)

    if (newFragment != null) {
        fTransaction
            .replace(R.id.placeholder, newFragment, tag)
            .addToBackStack(null)
            .commit()
    }


}
fun backListenerNull(tag: String, type:Int, fragmentManager: FragmentManager,button: MaterialButton){
    var fTransaction = fragmentManager.beginTransaction()
    when(type){
        1 -> {
            fTransaction
                .replace(R.id.placeholder, Fragment1.newInstance(), tag)
                .addToBackStack(null)
                .commit()
            button.setOnClickListener {
                backListener(tag,type,fragmentManager)
            }
        }
        2 -> {
            fTransaction
                .replace(R.id.placeholder, Fragment2.newInstance(), tag)
                .addToBackStack(null)
                .commit()
            button.setOnClickListener {
                backListener(tag,type,fragmentManager)
            }
        }
        3 -> {
            fTransaction
                .replace(R.id.placeholder, Fragment3.newInstance(), tag)
                .addToBackStack(null)
                .commit()
            button.setOnClickListener {
                backListener(tag,type,fragmentManager)
            }
        }
        4 -> {
            fTransaction
                .replace(R.id.placeholder, Fragment4.newInstance(), tag)
                .addToBackStack(null)
                .commit()
            button.setOnClickListener {
                backListener(tag,type,fragmentManager)
            }
        }
    }
}