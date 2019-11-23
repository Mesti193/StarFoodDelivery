package com.example.starFoodDelivery.util

import android.util.Log

fun Any.showELog(log: String) = Log.e(this::class.java.simpleName, log)

