package com.example.starFoodDelivery.presenters.login

import android.content.Context
import com.example.starFoodDelivery.contracts.login.LoginContract

class LoginPresenter: LoginContract.Presenter {
    private lateinit var view: LoginContract.View
    private lateinit var context: Context

    override fun attachView(baseView: LoginContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
    }

    override fun onForgotPasswordClick() = view.showToast("onForgotPasswordClick")

    override fun onLoginButtonClick(email: String, password: String) = view.showToast("onLoginButtonClick")

    override fun onFacebookButtonClick() = view.showToast("onFacebookButtonClick")

    override fun onGoogleButtonClick() = view.showToast("onGoogleButtonClick")

    override fun onCreateAccountClick() = view.showToast("onCreateAccountClick")

}