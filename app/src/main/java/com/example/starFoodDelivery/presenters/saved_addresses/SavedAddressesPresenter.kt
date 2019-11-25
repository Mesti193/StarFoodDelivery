package com.example.starFoodDelivery.presenters.saved_addresses

import android.content.Context
import com.example.starFoodDelivery.contracts.saved_addresses.SavedAddressesContract
import com.example.starFoodDelivery.domain.entities.SavedAddresses
import com.example.starFoodDelivery.ui.fragment.SetDeliveryLocationFragment
import com.example.starFoodDelivery.util.getDatabase
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SavedAddressesPresenter: SavedAddressesContract.Presenter {
    private lateinit var view: SavedAddressesContract.View
    private lateinit var context: Context

    override fun attachView(baseView: SavedAddressesContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
        getSavedAddresses()
    }

    private fun getSavedAddresses() {
        CompositeDisposable().add(
            getDatabase().SavedAddressesDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.displaySavedAddresses(it)
                }, {

                })
        )
    }

    override fun onEditItemClick(savedAddresses: SavedAddresses) = view.addContent(SetDeliveryLocationFragment().newInstance(savedAddresses), SetDeliveryLocationFragment.TAG)

    override fun onDeleteItemClick(savedAddresses: SavedAddresses) {
        CompositeDisposable().add(
            Completable.fromAction{ getDatabase().SavedAddressesDao().delete(savedAddresses) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    getSavedAddresses()
                }, {

                })
        )
    }

    override fun onAddNewAddressButtonClick() = view.addContent(SetDeliveryLocationFragment().newInstance(), SetDeliveryLocationFragment.TAG)
}