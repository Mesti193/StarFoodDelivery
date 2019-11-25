package com.example.starFoodDelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.util.TAG

class SetDeliveryLocationFragment: BaseHomePageFragment(), View.OnClickListener {
    companion object {
        val TAG: String = SetDeliveryLocationFragment.TAG()
    }

    fun newInstance(): SavedAddressesFragment {
        return SavedAddressesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_set_delivery_location, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View?) {

    }

}