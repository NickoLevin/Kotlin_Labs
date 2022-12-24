package com.example.fragmentproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentproject.databinding.FragmentFragment4Binding

class Fragment4 : Fragment() {
    lateinit var binding: FragmentFragment4Binding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragment4Binding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var firstFragInfo: String = ""
        var secondFragInfo: String = ""
        var thirdFragInfo: String = ""
        var fragmentManager = parentFragmentManager
        var fTransaction = fragmentManager.beginTransaction()
        var newFragment3: Fragment? = fragmentManager.findFragmentByTag(thirdTag)

        binding.buttonBackward4.setOnClickListener {
//            if(newFragment3 == null){
//                var button: Button = (activity as MainActivity).createNewButton("third")
//                backListenerNull(thirdTag,3,fragmentManager,button)
//            } else{
//               backListener(thirdTag,3,fragmentManager)
//            }
            backListener(thirdTag, 3, fragmentManager)
        }
        dataModel.messageFragment1.observe(activity as LifecycleOwner) {
            firstFragInfo = it
            Log.d("Fragg", "первый $it")
        }
        dataModel.messageFragment2.observe(activity as LifecycleOwner) {
            secondFragInfo = it
            Log.d("Fragg", "второй $it")
        }
        dataModel.messageFragment3.observe(activity as LifecycleOwner) {
            thirdFragInfo = it
            Log.d("Fragg", "третий $it")
        }
        if ((firstFragInfo == "") || (secondFragInfo == "") || (thirdFragInfo == "")) {
            binding.txView4.text = "Заполните, пожалуйста, прошлые поля"
        } else {
            var result: String = ""
            when (thirdFragInfo) {
                "+" -> {
                    result = (firstFragInfo.toFloat() + secondFragInfo.toFloat()).toString()
                }
                "-" -> {
                    result = (firstFragInfo.toFloat() - secondFragInfo.toFloat()).toString()
                }
                "*" -> {
                    result = (firstFragInfo.toFloat() * secondFragInfo.toFloat()).toString()
                }
                "/" -> {
                    result = (firstFragInfo.toFloat() / secondFragInfo.toFloat()).toString()
                }
            }
            binding.txView4.text =
                firstFragInfo + " " + thirdFragInfo + " " + secondFragInfo + " " + "=" + " " + result
        }
    }
    companion object {

        fun newInstance() = Fragment4()
    }
}