package com.example.starFoodDelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.ui.adapter.SavedCardsAdapter
import com.example.starFoodDelivery.util.TAG
import kotlinx.android.synthetic.main.fragment_payment_methods.*

class PaymentMethodsFragment: BaseHomePageFragment(), View.OnClickListener {

    companion object {
        val TAG: String = PaymentMethodsFragment.TAG()
    }

    fun newInstance(isEditPaymentMethodsSection: Boolean? = false): PaymentMethodsFragment {
        val paymentMethodsFragment = PaymentMethodsFragment()
        paymentMethodsFragment.isEditPaymentMethodsSection = isEditPaymentMethodsSection
        return paymentMethodsFragment
    }

    private lateinit var savedCardsAdapter: SavedCardsAdapter
    private var isEditPaymentMethodsSection: Boolean? = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_payment_methods, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedCardsAdapter = SavedCardsAdapter(isEditPaymentMethodsSection, mutableListOf("test"), {  }, { })
        rvSavedCards.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)
            adapter = savedCardsAdapter
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
        }
    }

}