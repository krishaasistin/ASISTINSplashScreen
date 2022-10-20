package com.example.examsplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examsplashscreen.databinding.ActivityMainBinding
import com.example.examsplashscreen.fragments.Fragment1
import com.example.examsplashscreen.fragments.Fragment2

class MainActivity : AppCompatActivity(), Fragment1.Fragment1Interface {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.frame1Edit.id,Fragment1())
        fragmentManager.commit()
    }

    override fun updateUsername() {
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.frame2Show.id, Fragment2())
        fragmentManager.commit()
    }
}