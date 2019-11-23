package com.example.starFoodDelivery.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.ui.fragment.LoginFragment
import com.example.starFoodDelivery.util.switchFragment
import com.example.starFoodDelivery.util.then
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchContent(
            LoginFragment().newInstance(),
            LoginFragment.TAG
        )
    }

    fun switchContent(fragment: androidx.fragment.app.Fragment, tag: String) {
        supportFragmentManager.switchFragment(R.id.clContainer, fragment, tag)
    }

    fun changeProgressBarVisibility(isVisible: Boolean) {
        progressBar.visibility = (isVisible then View.VISIBLE ?: View.GONE)
    }
}
