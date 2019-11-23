package com.example.starFoodDelivery.presenters.login

import android.content.Context
import com.example.starFoodDelivery.contracts.login.LoginContract
import com.example.starFoodDelivery.ui.fragment.OtpVerificationFragment
import com.example.starFoodDelivery.ui.fragment.SignUpFragment

class LoginPresenter: LoginContract.Presenter {
    private lateinit var view: LoginContract.View
    private lateinit var context: Context

    override fun attachView(baseView: LoginContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
    }

    override fun onForgotPasswordClick() = view.showToast("onForgotPasswordClick")

    override fun onLoginButtonClick(email: String, password: String) = view.addContent(OtpVerificationFragment().newInstance(), OtpVerificationFragment.TAG)

    override fun onFacebookButtonClick() = view.showToast("onFacebookButtonClick")

    override fun onGoogleButtonClick() = view.showToast("onGoogleButtonClick")

    override fun onCreateAccountClick() = view.addContent(SignUpFragment().newInstance(), SignUpFragment.TAG)

}