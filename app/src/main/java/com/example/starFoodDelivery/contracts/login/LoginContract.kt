package com.example.starFoodDelivery.contracts.login

import com.example.starFoodDelivery.contracts.BaseView
import com.example.starFoodDelivery.presenters.BasePresenter

interface LoginContract {

    interface View: BaseView {
        fun initView()
    }

    interface Presenter: BasePresenter<View> {
        fun onForgotPasswordClick()
        fun onLoginButtonClick(email: String, password: String)
        fun onFacebookButtonClick()
        fun onGoogleButtonClick()
        fun onCreateAccountClick()
    }

}