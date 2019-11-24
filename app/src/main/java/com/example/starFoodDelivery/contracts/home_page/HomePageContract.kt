package com.example.starFoodDelivery.contracts.home_page

import com.example.starFoodDelivery.presenters.BasePresenter

interface HomePageContract {

    interface View {
        fun initView()
        fun showToast(message: String)
        fun changeProgressBarVisibility(isVisible: Boolean)
        fun addContent(fragment: androidx.fragment.app.Fragment, tag: String)
        fun switchContent(fragment: androidx.fragment.app.Fragment, tag: String)
        fun changeBottomBarButtons(id: Int)
    }

    interface Presenter: BasePresenter<View> {
        fun onHomeButtonClick()
        fun onOffersButtonClick()
        fun onSearchButtonClick()
        fun onCartButtonClick()
        fun onMoreButtonClick()
    }

}