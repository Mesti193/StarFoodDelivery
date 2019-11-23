package com.example.starFoodDelivery.presenters.otp

import android.content.Context
import com.example.starFoodDelivery.contracts.otp.OtpContract


class OtpPresenter: OtpContract.Presenter {
    private lateinit var view: OtpContract.View
    private lateinit var context: Context

    override fun attachView(baseView: OtpContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
    }

    override fun onVerifyClick(otpCode: String) = view.showToast("onVerifyClick $otpCode")

}