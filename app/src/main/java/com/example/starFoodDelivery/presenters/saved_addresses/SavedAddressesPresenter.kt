package com.example.starFoodDelivery.presenters.saved_addresses

import android.content.Context
import com.example.starFoodDelivery.contracts.saved_addresses.SavedAddressesContract
import com.example.starFoodDelivery.ui.fragment.SetDeliveryLocationFragment

class SavedAddressesPresenter: SavedAddressesContract.Presenter {
    private lateinit var view: SavedAddressesContract.View
    private lateinit var context: Context

    override fun attachView(baseView: SavedAddressesContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
    }

    override fun onEditItemClick() = view.addContent(SetDeliveryLocationFragment().newInstance(), SetDeliveryLocationFragment.TAG)

    override fun onDeleteItemClick() = view.showToast("onDeleteItemClick")

    override fun onAddNewAddressButtonClick() = view.addContent(SetDeliveryLocationFragment().newInstance(), SetDeliveryLocationFragment.TAG)
}