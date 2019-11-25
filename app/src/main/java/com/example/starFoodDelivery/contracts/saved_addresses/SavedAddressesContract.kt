package com.example.starFoodDelivery.contracts.saved_addresses

import com.example.starFoodDelivery.contracts.BaseView
import com.example.starFoodDelivery.presenters.BasePresenter

interface SavedAddressesContract {

    interface View: BaseView {
        fun initView()
    }

    interface Presenter: BasePresenter<View> {
        fun onEditItemClick()
        fun onDeleteItemClick()
        fun onAddNewAddressButtonClick()
    }

}