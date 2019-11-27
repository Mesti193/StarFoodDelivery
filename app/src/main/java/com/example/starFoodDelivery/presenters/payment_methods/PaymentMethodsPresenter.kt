package com.example.starFoodDelivery.presenters.payment_methods

import android.content.Context
import com.example.starFoodDelivery.contracts.payment_methods.PaymentMethodsContract
import com.example.starFoodDelivery.domain.entities.SavedCards
import com.example.starFoodDelivery.ui.fragment.AddNewCardFragment
import com.example.starFoodDelivery.util.getDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PaymentMethodsPresenter: PaymentMethodsContract.Presenter {
    private lateinit var view: PaymentMethodsContract.View
    private lateinit var context: Context

    override fun attachView(baseView: PaymentMethodsContract.View, baseContext: Context) {
        view = baseView
        context = baseContext
        view.initView()
        getSavedCards()
    }

    private fun getSavedCards() {
        CompositeDisposable().add(
            getDatabase().SavedCardsDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.displaySavedCards(it)
                }, {

                })
        )
    }

    override fun onEditItemClick(savedAddresses: SavedCards) { }

    override fun onMakePaymentItemClick(savedAddresses: SavedCards) { }

    override fun onAddNewCardButtonClick() = view.addContent(AddNewCardFragment().newInstance(), AddNewCardFragment.TAG)

}