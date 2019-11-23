package com.example.starFoodDelivery.ui.fragment

import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.contracts.otp.OtpContract
import com.example.starFoodDelivery.presenters.otp.OtpPresenter
import com.example.starFoodDelivery.util.TAG
import com.example.starFoodDelivery.util.afterTextChanged
import com.example.starFoodDelivery.util.getString
import kotlinx.android.synthetic.main.fragment_otp_verification.*

class OtpVerificationFragment: BaseMainFragment(), OtpContract.View, View.OnClickListener {
    companion object {
        val TAG: String = OtpVerificationFragment.TAG()
    }

    fun newInstance(): OtpVerificationFragment {
        return OtpVerificationFragment()
    }

    private lateinit var presenter: OtpContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_otp_verification, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = OtpPresenter()
        presenter.attachView(this, context!!)
    }

    override fun initView() {
        ivBack?.setOnClickListener(this)
        btVerify?.setOnClickListener(this)
        otp_view?.filters = arrayOf(InputFilter.AllCaps(), InputFilter.LengthFilter(4))
        otp_view?.afterTextChanged {
            btVerify?.apply {
                if(it.length == 4){
                    setBackgroundColor(ContextCompat.getColor(context!!, R.color.splash_screen_bg))
                    isEnabled = true
                    isClickable = true
                }else{
                    setBackgroundColor(ContextCompat.getColor(context!!, R.color.light_grey))
                    isEnabled = false
                    isClickable = false
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            ivBack?.id -> mainActivity.onBackPressed()
            btVerify?.id -> presenter.onVerifyClick(otp_view.getString())
        }
    }

}

