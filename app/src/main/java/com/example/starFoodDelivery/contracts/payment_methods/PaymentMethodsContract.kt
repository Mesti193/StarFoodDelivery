package com.example.starFoodDelivery.contracts.payment_methods

import com.example.starFoodDelivery.contracts.BaseView
import com.example.starFoodDelivery.domain.entities.SavedCards
import com.example.starFoodDelivery.presenters.BasePresenter

interface PaymentMethodsContract {

    interface View: BaseView {
        fun initView()
        fun displaySavedCards(savedCards: MutableList<SavedCards>)
    }

    interface Presenter: BasePresenter<View> {
        fun onEditItemClick(savedAddresses: SavedCards)
        fun onMakePaymentItemClick(savedAddresses: SavedCards)
        fun onAddNewCardButtonClick()
    }

}