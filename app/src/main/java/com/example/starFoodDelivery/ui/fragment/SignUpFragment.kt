package com.example.starFoodDelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.contracts.signup.SignUpContract
import com.example.starFoodDelivery.presenters.signup.SignUpPresenter
import com.example.starFoodDelivery.util.TAG
import com.example.starFoodDelivery.util.afterTextChanged
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpFragment: BaseMainFragment(), SignUpContract.View, View.OnClickListener{
    companion object {
        val TAG: String = SignUpFragment.TAG()
    }

    fun newInstance(): SignUpFragment {
        return SignUpFragment()
    }

    private lateinit var presenter: SignUpContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_signup, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = SignUpPresenter()
        presenter.attachView(this, context!!)
    }

    override fun initView() {
        ivBack?.setOnClickListener(this)
        btCreateAccount?.setOnClickListener(this)
        btCreateAccount?.setOnClickListener(this)
        tvNoAccount?.setOnClickListener(this)

        etMobileNumber.afterTextChanged { validate() }
        etFullName.afterTextChanged { validate() }
        etEmail.afterTextChanged { validate() }
        etPassword.afterTextChanged { validate() }
    }

    private fun validate(){
        val mobileNumber: Boolean = etMobileNumber.text?.isNotEmpty()!!
        val fullName: Boolean = etFullName.text?.isNotEmpty()!!
        val mail: Boolean = etEmail.text?.isNotEmpty()!!
        val password: Boolean = etPassword.text?.isNotEmpty()!!

        btCreateAccount?.apply {
            if(mobileNumber && fullName && mail && password){
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

    override fun onClick(v: View?) {
        when(v?.id){
            ivBack?.id -> mainActivity.onBackPressed()
            btCreateAccount?.id -> presenter.onCreateAccountButtonClick()
            tvNoAccount?.id -> presenter.onTermsClick()
        }
    }

}
