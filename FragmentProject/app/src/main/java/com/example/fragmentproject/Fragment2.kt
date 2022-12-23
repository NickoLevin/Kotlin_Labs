package com.example.fragmentproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentproject.databinding.FragmentFragment2Binding
import com.google.android.material.button.MaterialButton


class Fragment2 : Fragment() {
    lateinit var binding: FragmentFragment2Binding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragment2Binding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var fragmentManager = parentFragmentManager
        var newFragment1: Fragment? = fragmentManager.findFragmentByTag(firstTag)
        var newFragment3: Fragment? = fragmentManager.findFragmentByTag(thirdTag)
        binding.buttonBackward2.setOnClickListener {            //кнопка назад
//            if (newFragment1 == null) {
//                var button : Button = (activity as MainActivity).createNewButton("first")
//                backListenerNull(firstTag, 1, fragmentManager,button)
//            } else{
//                backListener(firstTag,1,fragmentManager)
//            }
            backListener(firstTag,1,fragmentManager)
        }
        binding.buttonForward2.setOnClickListener {
            if(newFragment3 == null){
                var button : MaterialButton = (activity as MainActivity).createNewMaterialButton("third")
                backListenerNull(thirdTag,3,fragmentManager,button)
            } else{
                backListener(thirdTag,3,fragmentManager)
            }
        }
        val edit = binding.edtTextFrag2
        edit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                dataModel.messageFragment2.value= edit.text.toString()

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    companion object {

        fun newInstance() = Fragment2()
    }
}