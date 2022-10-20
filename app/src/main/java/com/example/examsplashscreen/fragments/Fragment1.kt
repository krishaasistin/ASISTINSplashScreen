package com.example.examsplashscreen.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examsplashscreen.PREFERENCES
import com.example.examsplashscreen.R
import com.example.examsplashscreen.USERNAME
import com.example.examsplashscreen.databinding.Fragment1Binding

class Fragment1 : Fragment(), View.OnClickListener {

    private lateinit var binding : Fragment1Binding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var fragment1Interface: Fragment1Interface

    interface Fragment1Interface {
        fun updateUsername()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragment1Interface = context as Fragment1Interface
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCES,Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSaveUser.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.btnSaveUser -> {
                var username = binding.txtEditUser.text.toString()
                if (username == "") {
                    binding.txtEditUser.error = "This is required"
                    return
                } else if (username.length < 6) {
                    binding.txtEditUser.error = "It must be 6 characters long"
                    return
                } else {

                    val editor = sharedPreferences.edit()
                    editor.putString(USERNAME, username)
                    editor.apply()

                    fragment1Interface.updateUsername()
                }
            }
        }
    }
}