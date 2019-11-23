package com.example.starFoodDelivery.ui.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.starFoodDelivery.contracts.BaseView
import com.example.starFoodDelivery.ui.activity.MainActivity
import com.example.starFoodDelivery.util.toast

open class BaseMainFragment: Fragment(), BaseView {

    open lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = (activity as MainActivity)
    }

    override fun showToast(message: String) = toast(message)

    override fun isProgressBarVisible(isVisible: Boolean) = mainActivity.changeProgressBarVisibility(isVisible)

    override fun addContent(fragment: Fragment, tag: String) = mainActivity.addContent(fragment, tag)

    override fun switchContent(fragment: Fragment, tag: String) = mainActivity.switchContent(fragment, tag)

    override fun startActivity(activity: Activity) {
        mainActivity.startActivity(Intent(mainActivity, activity::class.java))
        mainActivity.finish()
    }

}