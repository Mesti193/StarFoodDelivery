package com.example.starFoodDelivery.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.contracts.home_page.HomePageContract
import com.example.starFoodDelivery.presenters.home_page.HomePagePresenter
import com.example.starFoodDelivery.util.addFragment
import com.example.starFoodDelivery.util.switchFragment
import com.example.starFoodDelivery.util.then
import com.example.starFoodDelivery.util.toast
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity: AppCompatActivity(), HomePageContract.View, View.OnClickListener {
    companion object{
        const val HOME_BUTTON = 1
        const val OFFERS_BUTTON = 2
        const val SEARCH_BUTTON = 3
        const val CART_BUTTON = 4
        const val MORE_BUTTON = 5
    }

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
        presenter.onMoreButtonClick()
    }

    override fun changeBottomBarButtons(id: Int) {
        setDefaultDrawable()
        when(id){
            HOME_BUTTON -> ivHome?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_home_clicked))
            OFFERS_BUTTON -> ivOffers?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_search_clicked))
            SEARCH_BUTTON -> ivSearch?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_loupe_clicked))
            CART_BUTTON -> ivCart?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_shopping_cart_clicked))
            MORE_BUTTON -> ivMore?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_more_clicked))
        }
    }

    private fun setDefaultDrawable(){
        ivHome?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_home))
        ivOffers?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_search))
        ivSearch?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_loupe))
        ivCart?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_shopping_cart))
        ivMore?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_more))
    }

    override fun showToast(message: String) = toast(message)

    override fun addContent(fragment: androidx.fragment.app.Fragment, tag: String) = supportFragmentManager.addFragment(R.id.clContainer, fragment, tag)

    override fun switchContent(fragment: androidx.fragment.app.Fragment, tag: String) = supportFragmentManager.switchFragment(R.id.clContainer, fragment, tag)

    override fun changeProgressBarVisibility(isVisible: Boolean) {
        progressBar.visibility = (isVisible then View.VISIBLE ?: View.GONE)
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

}
