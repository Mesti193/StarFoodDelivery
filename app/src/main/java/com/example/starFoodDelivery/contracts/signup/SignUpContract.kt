package com.example.starFoodDelivery.contracts.signup

import com.example.starFoodDelivery.contracts.BaseView
import com.example.starFoodDelivery.presenters.BasePresenter

interface SignUpContract {

    interface View: BaseView {
        fun initView()
    }

    interface Presenter: BasePresenter<View> {
        fun onCreateAccountButtonClick()
        fun onTermsClick()
    }

}