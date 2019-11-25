package com.example.starFoodDelivery.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.starFoodDelivery.R

class SplashActivity : AppCompatActivity() {
    companion object{
        private const val SPLASH_TIME_OUT: Long = 2500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
                        startActivity(Intent(this, HomePageActivity::class.java))
//            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}