package com.example.starFoodDelivery.presenters.options

import android.content.Context
import com.example.starFoodDelivery.contracts.options.OptionsContract
import com.example.starFoodDelivery.ui.fragment.SavedAddressesFragment
import com.example.starFoodDelivery.ui.activity.MainActivity

class OptionsPresenter: OptionsContract.Presenter {
    private lateinit var view: OptionsContract.View
    private lateinit var context: Context

    override fun attachView(baseView: OptionsContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
    }

    override fun onEditProfileClick() = view.showToast("onEditProfileClick")

    override fun onMyAccountSectionClick(isVisible: Boolean) = view.setMyAccountSectionVisibility(isVisible)

    override fun onManageAddressClick() = view.addContent(SavedAddressesFragment().newInstance(), SavedAddressesFragment.TAG)

    override fun onPaymentClick() = view.showToast("onPaymentClick")

    override fun onFavouritesClick() = view.showToast("onFavouritesClick")

    override fun onRefferalsClick() = view.showToast("onRefferalsClick")

    override fun onOffersClick() = view.showToast("onOffersClick")

    override fun onHelpSectionClick() = view.showToast("onHelpSectionClick")

    override fun onRecentOrdersSectionClick() = view.showToast("onRecentOrdersSectionClick")

    override fun onLogoutClick() = view.startActivity(MainActivity())


}