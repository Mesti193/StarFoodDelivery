package com.example.starFoodDelivery.ui.fragment

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.contracts.delivery_location.SetDeliveryLocationContract
import com.example.starFoodDelivery.domain.entities.SavedAddresses
import com.example.starFoodDelivery.presenters.delivery_location.SetDeliveryLocationPresenter
import com.example.starFoodDelivery.util.TAG
import com.example.starFoodDelivery.util.text
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.fragment_set_delivery_location.*

class SetDeliveryLocationFragment: BaseHomePageFragment(), SetDeliveryLocationContract.View, View.OnClickListener, OnMapReadyCallback {
    companion object {
        val TAG: String = SetDeliveryLocationFragment.TAG()
        const val HOME = 1
        const val OFFICE = 2
        const val OTHER = 3
    }

    private var savedAddresses: SavedAddresses? = null

    fun newInstance(savedAddresses: SavedAddresses? = null): SetDeliveryLocationFragment {
        val setDeliveryLocationFragment = SetDeliveryLocationFragment()
        setDeliveryLocationFragment.savedAddresses = savedAddresses
        return setDeliveryLocationFragment
    }

    private lateinit var presenter: SetDeliveryLocationContract.Presenter
//    private lateinit var mMap: GoogleMap
    private lateinit var saveAsSection: MutableList<TextView?>
    private var type: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_set_delivery_location, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = SetDeliveryLocationPresenter()
        presenter.attachView(this, context!!)
    }

    override fun initView() {
        saveAsSection = mutableListOf(tvSaveAsHome, tvSaveAsOffice, tvSaveAsOther)
        ivBack?.setOnClickListener(this)
        tvSaveAsHome?.setOnClickListener(this)
        tvSaveAsOffice?.setOnClickListener(this)
        tvSaveAsOther?.setOnClickListener(this)
        btSaveLocation?.setOnClickListener(this)
//        (activity!!.supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)?.getMapAsync(this)

        if(savedAddresses != null){
            etLocation?.setText(savedAddresses!!.address)
            etHouse?.setText(savedAddresses!!.houseNumber)
            etCity?.setText(savedAddresses!!.city)
            etCountry?.setText(savedAddresses!!.country)
            changeAddressType(savedAddresses!!.type)
        }

    }

    override fun changeAddressType(id: Int) {
        type = id
        addUnderline(when(id){
            HOME -> tvSaveAsHome
            OFFICE -> tvSaveAsOffice
            OTHER -> tvSaveAsOther
            else -> null})
    }

    private fun addUnderline(tv: TextView?){
        removeUnderline()
        tv?.apply {
            paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
            setTextColor(ContextCompat.getColor(context!!, R.color.dark_blue))
        }
    }

    private fun removeUnderline(){
        saveAsSection.forEach {
            it?.paintFlags = 0
            it?.setTextColor(ContextCompat.getColor(context!!, R.color.dark_grey))
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            ivBack?.id -> mainActivity.onBackPressed()
            tvSaveAsHome?.id -> presenter.onAddressTypeClick(HOME)
            tvSaveAsOffice?.id -> presenter.onAddressTypeClick(OFFICE)
            tvSaveAsOther?.id -> presenter.onAddressTypeClick(OTHER)
            btSaveLocation?.id -> {
                if(savedAddresses != null){
                    presenter.onSaveLocationClick(SavedAddresses(savedAddresses!!.id, type!!, etLocation.text(), etHouse.text(), etCity.text(), etCountry.text()))
                }else{
                    presenter.onSaveLocationClick(SavedAddresses(type = type!!, address = etLocation.text(), houseNumber = etHouse.text(), city = etCity.text(), country = etCountry.text()))
                }
            }
        }
    }

    override fun backToPreviousScreen() = mainActivity.onBackPressed()

    override fun onMapReady(p0: GoogleMap?) {
//        mMap = p0!!
    }

}