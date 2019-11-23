package com.example.starFoodDelivery.presenters.signup

import android.content.Context
import com.example.starFoodDelivery.contracts.signup.SignUpContract
import com.example.starFoodDelivery.ui.fragment.OtpVerificationFragment


class SignUpPresenter: SignUpContract.Presenter {
    private lateinit var view: SignUpContract.View
    private lateinit var context: Context

    override fun attachView(baseView: SignUpContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
    }

//    override fun onCreateAccountButtonClick() = view.showToast("onCreateAccountButtonClick")
    override fun onCreateAccountButtonClick() = view.addContent(OtpVerificationFragment().newInstance(), OtpVerificationFragment.TAG)

    override fun onTermsClick() = view.showToast("onTermsClick")

}