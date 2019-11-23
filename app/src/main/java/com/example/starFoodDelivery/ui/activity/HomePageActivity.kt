package com.example.starFoodDelivery.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.contracts.home_page.HomePageContract
import com.example.starFoodDelivery.presenters.home_page.HomePagePresenter
import com.example.starFoodDelivery.util.addFragment
import com.example.starFoodDelivery.util.switchFragment
import com.example.starFoodDelivery.util.then
import com.example.starFoodDelivery.util.toast
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity: AppCompatActivity(), HomePageContract.View, View.OnClickListener {

    private lateinit var presenter: HomePageContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        presenter = HomePagePresenter()
        presenter.attachView(this, this)
    }

    override fun initView() {
        ivHome?.setOnClickListener(this)
        tvHome?.setOnClickListener(this)
        ivOffers?.setOnClickListener(this)
        tvOffers?.setOnClickListener(this)
        ivSearch?.setOnClickListener(this)
        tvSearch?.setOnClickListener(this)
        ivCart?.setOnClickListener(this)
        tvCart?.setOnClickListener(this)
        ivMore?.setOnClickListener(this)
        tvMore?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            ivHome?.id, tvHome?.id -> presenter.onHomeButtonClick()
            ivOffers?.id, tvOffers?.id -> presenter.onOffersButtonClick()
            ivSearch?.id, tvSearch?.id -> presenter.onSearchButtonClick()
            ivCart?.id, tvCart?.id -> presenter.onCartButtonClick()
            ivMore?.id, tvMore?.id -> presenter.onMoreButtonClick()
        }
    }

    override fun showToast(message: String) = toast(message)

    override fun addContent(fragment: androidx.fragment.app.Fragment, tag: String) = supportFragmentManager.addFragment(R.id.clContainer, fragment, tag)

    override fun switchContent(fragment: androidx.fragment.app.Fragment, tag: String) = supportFragmentManager.switchFragment(R.id.clContainer, fragment, tag)

    override fun changeProgressBarVisibility(isVisible: Boolean) {
        progressBar.visibility = (isVisible then View.VISIBLE ?: View.GONE)
    }

}
