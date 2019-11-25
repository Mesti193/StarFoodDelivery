package com.example.starFoodDelivery.presenters.home_page

import android.content.Context
import com.example.starFoodDelivery.contracts.home_page.HomePageContract
import com.example.starFoodDelivery.ui.activity.HomePageActivity
import com.example.starFoodDelivery.ui.fragment.HomeFragment
import com.example.starFoodDelivery.ui.fragment.OptionsFragment

class HomePagePresenter: HomePageContract.Presenter {
    private lateinit var view: HomePageContract.View
    private lateinit var context: Context

    override fun attachView(baseView: HomePageContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
    }

    override fun onHomeButtonClick() {
        view.changeBottomBarButtons(HomePageActivity.HOME_BUTTON)
        view.switchContent(HomeFragment().newInstance(), HomeFragment.TAG)
    }

    override fun onOffersButtonClick() {
        view.changeBottomBarButtons(HomePageActivity.OFFERS_BUTTON)
        view.showToast("onOffersButtonClick")
    }

    override fun onSearchButtonClick() {
        view.changeBottomBarButtons(HomePageActivity.SEARCH_BUTTON)
        view.showToast("onSearchButtonClick")
    }

    override fun onCartButtonClick() {
        view.changeBottomBarButtons(HomePageActivity.CART_BUTTON)
        view.showToast("onCartButtonClick")
    }

    override fun onMoreButtonClick() {
        view.changeBottomBarButtons(HomePageActivity.MORE_BUTTON)
        view.switchContent(OptionsFragment().newInstance(), OptionsFragment.TAG)
    }
}