package com.example.fragmentproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import com.example.fragmentproject.databinding.FragmentFragment3Binding
import com.google.android.material.button.MaterialButton

class Fragment3 : Fragment() {
    lateinit var binding: FragmentFragment3Binding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragment3Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var fragmentManager = parentFragmentManager
        var fTransaction = fragmentManager.beginTransaction()
        var newFragment2: Fragment? = fragmentManager.findFragmentByTag(secondTag)
        var newFragment4: Fragment? = fragmentManager.findFragmentByTag(fourthTag)
        binding.buttonBackward3.setOnClickListener {            //кнопка назад
//            if(newFragment2 == null){
//                var button : Button = (activity as MainActivity).createNewButton("second")
//                backListenerNull(secondTag,2,fragmentManager,button)
//            } else{
//                backListener(secondTag,2,fragmentManager)
//            }
            backListener(secondTag,2,fragmentManager)
        }
        var radioGroup = binding.RadioGroup3Id
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{group, checkedId ->
            val radio:RadioButton = group.findViewById(checkedId)
            Log.d("Fragg",radio.text.toString())
            when(radio.id){

                R.id.radioButton -> {
                    dataModel.messageFragment3.value= "+"

                }
                R.id.radioButton2 ->{
                    dataModel.messageFragment3.value= "-"
                }
                R.id.radioButton3 ->{
                    dataModel.messageFragment3.value= "*"
                }
                R.id.radioButton4 ->{
                    dataModel.messageFragment3.value= "/"
                }
            }
        })

        binding.buttonForward3.setOnClickListener {
            if(newFragment4 == null){
                var button : MaterialButton = (activity as MainActivity).createNewMaterialButton("fourth")
                backListenerNull(fourthTag,4,fragmentManager,button)
            } else{
                backListener(fourthTag,4,fragmentManager)
            }
        }

    }
    companion object {

        fun newInstance() = Fragment3()
    }
}