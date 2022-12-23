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
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentproject.databinding.FragmentFragment1Binding
import com.google.android.material.button.MaterialButton


class Fragment1 : Fragment() {
    lateinit var binding: FragmentFragment1Binding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var fragmentManager = parentFragmentManager
        var fTransaction = fragmentManager.beginTransaction()
        var fragment: Fragment? = fragmentManager.findFragmentByTag(secondTag)

        binding.buttonForward1.setOnClickListener {
            if(fragment == null){
                var button : MaterialButton = (activity as MainActivity).createNewMaterialButton("second")
                backListenerNull(secondTag,2,fragmentManager,button)
            } else{
                backListener(secondTag,2,fragmentManager)
            }
        }
        val edit = binding.edtTextFrag1
        edit.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                dataModel.messageFragment1.value= edit.text.toString()

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }
    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}