package com.example.starFoodDelivery.contracts.otp

import com.example.starFoodDelivery.contracts.BaseView
import com.example.starFoodDelivery.presenters.BasePresenter

interface OtpContract {

    interface View: BaseView {
        fun initView()
    }

    interface Presenter: BasePresenter<View> {
        fun onVerifyClick(otpCode: String)
    }

}