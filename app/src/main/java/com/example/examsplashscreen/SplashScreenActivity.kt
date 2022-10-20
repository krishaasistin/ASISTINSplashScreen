package com.example.examsplashscreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.examsplashscreen.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivitySplashScreenBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        val username = sharedPreferences.getString(USERNAME, "").toString()
        supportActionBar?.hide()

        if(username == "") {
            binding.txtWelcome.text = "Welcome to my Application!"
        }
        else{
            binding.txtWelcome.text = String.format("Welcome to my Application, %s!",username)
        }

        object: CountDownTimer(5000,1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                val intent = Intent(this@SplashScreenActivity,MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }.start()
    }
}