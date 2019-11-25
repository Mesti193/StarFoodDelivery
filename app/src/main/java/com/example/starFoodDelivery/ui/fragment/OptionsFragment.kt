package com.example.starFoodDelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.contracts.options.OptionsContract
import com.example.starFoodDelivery.presenters.options.OptionsPresenter
import com.example.starFoodDelivery.util.TAG
import com.example.starFoodDelivery.util.showELog
import com.example.starFoodDelivery.util.visibility
import kotlinx.android.synthetic.main.fragment_options.*

class OptionsFragment: BaseHomePageFragment(), OptionsContract.View, View.OnClickListener {

    companion object {
        val TAG: String = OptionsFragment.TAG()
    }

    fun newInstance(): OptionsFragment {
        return OptionsFragment()
    }

    private lateinit var presenter: OptionsContract.Presenter
    private lateinit var myAccountSectionViews: MutableList<View?>

    private var isMyAccountSectionVisible: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_options, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isMyAccountSectionVisible = false
        presenter = OptionsPresenter()
        presenter.attachView(this, context!!)
    }

    override fun initView() {
        myAccountSectionViews = mutableListOf(vSeparatorAccount, tvManageAddress, ivManageAddress, tvPayment, ivPayment, tvFavourites, ivFavourites, tvRefferals, ivRefferals, tvOffers, ivOffers)
        setMyAccountSectionVisibility(isMyAccountSectionVisible)
        tvEdit?.setOnClickListener(this)
        tvMyAccount?.setOnClickListener(this)
        tvMyAccountDesc?.setOnClickListener(this)
        ivAccountList?.setOnClickListener(this)
        tvManageAddress?.setOnClickListener(this)
        ivManageAddress?.setOnClickListener(this)
        tvPayment?.setOnClickListener(this)
        ivPayment?.setOnClickListener(this)
        tvFavourites?.setOnClickListener(this)
        ivFavourites?.setOnClickListener(this)
        tvRefferals?.setOnClickListener(this)
        ivRefferals?.setOnClickListener(this)
        tvOffers?.setOnClickListener(this)
        ivOffers?.setOnClickListener(this)
        tvHelp?.setOnClickListener(this)
        tvHelpDesc?.setOnClickListener(this)
        ivHelp?.setOnClickListener(this)
        tvRecentOrders?.setOnClickListener(this)
        tvRecentOrdersDesc?.setOnClickListener(this)
        ivRecentOrder?.setOnClickListener(this)
        tvLogout?.setOnClickListener(this)
    }

    override fun setMyAccountSectionVisibility(isVisible: Boolean) {
        if(isVisible){
            myAccountSectionViews.visibility(View.VISIBLE)
            ivAccountList?.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.ic_arrow_down))
        }else{
            myAccountSectionViews.visibility(View.GONE)
            ivAccountList?.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.ic_arrow_right))
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            tvEdit?.id -> presenter.onEditProfileClick()
            tvMyAccount?.id, tvMyAccountDesc?.id, ivAccountList?.id -> {
                isMyAccountSectionVisible = !isMyAccountSectionVisible
                presenter.onMyAccountSectionClick(isMyAccountSectionVisible)
            }
            tvManageAddress?.id, ivManageAddress?.id -> presenter.onManageAddressClick()
            tvPayment?.id, ivPayment?.id -> presenter.onPaymentClick()
            tvFavourites?.id, ivFavourites?.id -> presenter.onFavouritesClick()
            tvRefferals?.id, ivRefferals?.id -> presenter.onRefferalsClick()
            tvOffers?.id, ivOffers?.id -> presenter.onOffersClick()
            tvHelp?.id, tvHelpDesc?.id, ivHelp?.id -> presenter.onHelpSectionClick()
            tvRecentOrders?.id, tvRecentOrdersDesc?.id, ivRecentOrder?.id -> presenter.onRecentOrdersSectionClick()
            tvLogout?.id -> presenter.onLogoutClick()
        }
    }

}