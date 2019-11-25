package com.example.starFoodDelivery.contracts.saved_addresses

import com.example.starFoodDelivery.contracts.BaseView
import com.example.starFoodDelivery.domain.entities.SavedAddresses
import com.example.starFoodDelivery.presenters.BasePresenter

interface SavedAddressesContract {

    interface View: BaseView {
        fun initView()
        fun displaySavedAddresses(savedAddresses: MutableList<SavedAddresses>)
    }

    interface Presenter: BasePresenter<View> {
        fun onEditItemClick(savedAddresses: SavedAddresses)
        fun onDeleteItemClick(savedAddresses: SavedAddresses)
        fun onAddNewAddressButtonClick()
    }

}