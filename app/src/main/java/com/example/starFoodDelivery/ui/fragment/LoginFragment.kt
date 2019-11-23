package com.example.starFoodDelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.contracts.login.LoginContract
import com.example.starFoodDelivery.presenters.login.LoginPresenter
import com.example.starFoodDelivery.util.TAG
import com.example.starFoodDelivery.util.text
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: BaseMainFragment(), LoginContract.View, View.OnClickListener{
    companion object {
        val TAG: String = LoginFragment.TAG()
    }

    fun newInstance(): LoginFragment {
        return LoginFragment()
    }

    private lateinit var presenter: LoginContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LoginPresenter()
        presenter.attachView(this, context!!)
    }

    override fun initView() {
        tvForgotPassword?.setOnClickListener(this)
        btLogin?.setOnClickListener(this)
        btFacebook?.setOnClickListener(this)
        btGoogle?.setOnClickListener(this)
        tvNoAccount?.setOnClickListener(this)
        tvCreateNow?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            tvForgotPassword?.id -> presenter.onForgotPasswordClick()
            btLogin?.id -> presenter.onLoginButtonClick(etEmail.text(), etPassword.text())
            btFacebook?.id -> presenter.onFacebookButtonClick()
            btGoogle?.id -> presenter.onGoogleButtonClick()
            tvNoAccount?.id, tvCreateNow?.id -> presenter.onCreateAccountClick()
        }
    }

}

























