package com.example.starFoodDelivery.presenters

import android.content.Context

interface BasePresenter<in T> {
    fun attachView(baseView: T, baseContext: Context)
}