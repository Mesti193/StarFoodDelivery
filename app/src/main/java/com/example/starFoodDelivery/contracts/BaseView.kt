package com.example.starFoodDelivery.contracts

interface BaseView {
    fun showToast(message: String)
    fun isProgressBarVisible(isVisible: Boolean)
    fun switchContent(fragment: androidx.fragment.app.Fragment, tag: String)
}