package com.example.starFoodDelivery.contracts.delivery_location

import com.example.starFoodDelivery.contracts.BaseView
import com.example.starFoodDelivery.domain.entities.SavedAddresses
import com.example.starFoodDelivery.presenters.BasePresenter

interface SetDeliveryLocationContract {

    interface View: BaseView {
        fun initView()
        fun changeAddressType(id: Int)
        fun backToPreviousScreen()
    }

    interface Presenter: BasePresenter<View> {
        fun onAddressTypeClick(id: Int)
        fun onSaveLocationClick(savedAddresses: SavedAddresses)
    }

}