package com.example.starFoodDelivery.contracts

import android.app.Activity

interface BaseView {
    fun showToast(message: String)
    fun isProgressBarVisible(isVisible: Boolean)
    fun addContent(fragment: androidx.fragment.app.Fragment, tag: String)
    fun switchContent(fragment: androidx.fragment.app.Fragment, tag: String)
    fun startActivity(activity: Activity)
}