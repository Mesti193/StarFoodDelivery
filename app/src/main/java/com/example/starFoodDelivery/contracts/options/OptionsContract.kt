package com.example.starFoodDelivery.contracts.options

import com.example.starFoodDelivery.contracts.BaseView
import com.example.starFoodDelivery.presenters.BasePresenter

interface OptionsContract {

    interface View: BaseView {
        fun initView()
        fun setMyAccountSectionVisibility(isVisible: Boolean)
    }

    interface Presenter: BasePresenter<View> {
        fun onEditProfileClick()
        fun onMyAccountSectionClick(isVisible: Boolean)
        fun onManageAddressClick()
        fun onPaymentClick()
        fun onFavouritesClick()
        fun onRefferalsClick()
        fun onOffersClick()
        fun onHelpSectionClick()
        fun onRecentOrdersSectionClick()
        fun onLogoutClick()
    }

}