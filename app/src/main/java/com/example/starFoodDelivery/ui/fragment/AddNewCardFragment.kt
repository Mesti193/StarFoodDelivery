package com.example.starFoodDelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.util.TAG
import kotlinx.android.synthetic.main.fragment_add_new_card.*

class AddNewCardFragment: BaseHomePageFragment(), View.OnClickListener {
    companion object {
        val TAG: String = AddNewCardFragment.TAG()
    }

    fun newInstance(): AddNewCardFragment {
        return AddNewCardFragment()
    }

    override fun onCreateView(inflater:  LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_add_new_card, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivBack?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            ivBack?.id -> mainActivity.onBackPressed()
        }
    }

}