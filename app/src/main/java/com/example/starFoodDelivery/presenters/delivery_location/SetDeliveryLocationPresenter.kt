package com.example.starFoodDelivery.presenters.delivery_location

import android.content.Context
import com.example.starFoodDelivery.contracts.delivery_location.SetDeliveryLocationContract
import com.example.starFoodDelivery.domain.entities.SavedAddresses
import com.example.starFoodDelivery.util.getDatabase
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SetDeliveryLocationPresenter: SetDeliveryLocationContract.Presenter {
    private lateinit var view: SetDeliveryLocationContract.View
    private lateinit var context: Context

    override fun attachView(baseView: SetDeliveryLocationContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
    }

    override fun onAddressTypeClick(id: Int) = view.changeAddressType(id)

    override fun onSaveLocationClick(savedAddresses: SavedAddresses) {
        CompositeDisposable().add(
            if(savedAddresses.id != null){
                Completable.fromAction{ getDatabase().SavedAddressesDao().update(savedAddresses.id!!, savedAddresses.type, savedAddresses.address, savedAddresses.houseNumber, savedAddresses.city, savedAddresses.country) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ view.backToPreviousScreen() }, { })
            }else{
                Completable.fromAction{ getDatabase().SavedAddressesDao().insertAll(savedAddresses) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ view.backToPreviousScreen() }, { })
            }
        )
    }

}