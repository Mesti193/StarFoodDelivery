package com.example.starFoodDelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.contracts.saved_addresses.SavedAddressesContract
import com.example.starFoodDelivery.domain.entities.SavedAddresses
import com.example.starFoodDelivery.presenters.saved_addresses.SavedAddressesPresenter
import com.example.starFoodDelivery.ui.adapter.SavedAddressesAdapter
import com.example.starFoodDelivery.util.TAG
import kotlinx.android.synthetic.main.fragment_saved_addresses.*

class SavedAddressesFragment: BaseHomePageFragment(), SavedAddressesContract.View, View.OnClickListener {

    companion object {
        val TAG: String = SavedAddressesFragment.TAG()
    }

    fun newInstance(): SavedAddressesFragment {
        return SavedAddressesFragment()
    }

    private lateinit var presenter: SavedAddressesContract.Presenter
    private lateinit var savedAddressesAdapter: SavedAddressesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_saved_addresses, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = SavedAddressesPresenter()
        presenter.attachView(this, context!!)
    }

    override fun initView() {
        ivBack?.setOnClickListener(this)
        btAddAddress?.setOnClickListener(this)
    }

    override fun displaySavedAddresses(savedAddresses: MutableList<SavedAddresses>) {
        savedAddressesAdapter = SavedAddressesAdapter(savedAddresses, { presenter.onEditItemClick(it) }, { presenter.onDeleteItemClick(it) })
        rvSavedAddresses.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)
            adapter = savedAddressesAdapter
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            ivBack?.id -> mainActivity.onBackPressed()
            btAddAddress?.id -> presenter.onAddNewAddressButtonClick()
        }
    }

}