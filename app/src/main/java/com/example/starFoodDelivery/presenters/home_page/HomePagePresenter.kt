package com.example.starFoodDelivery.presenters.home_page

import android.content.Context
import com.example.starFoodDelivery.contracts.home_page.HomePageContract

class HomePagePresenter: HomePageContract.Presenter {
    private lateinit var view: HomePageContract.View
    private lateinit var context: Context

    override fun attachView(baseView: HomePageContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
    }

    override fun onHomeButtonClick() = view.showToast("onHomeButtonClick")

    override fun onOffersButtonClick() = view.showToast("onOffersButtonClick")

    override fun onSearchButtonClick() = view.showToast("onSearchButtonClick")

    override fun onCartButtonClick() = view.showToast("onCartButtonClick")

    override fun onMoreButtonClick() = view.showToast("onMoreButtonClick")
}