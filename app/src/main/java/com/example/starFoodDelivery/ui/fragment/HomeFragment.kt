package com.example.starFoodDelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.ui.adapter.TopRestaurantsNearAdapter
import com.example.starFoodDelivery.util.TAG
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseHomePageFragment(), View.OnClickListener{
    companion object {
        val TAG: String = HomeFragment.TAG()
    }

    fun newInstance(): HomeFragment {
        return HomeFragment()
    }
    private lateinit var topRestaurantsNearAdapter: TopRestaurantsNearAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tt = mutableListOf("Hejka", "luzik", "arbuzik xD", "eloszka", "kokoszka")

        topRestaurantsNearAdapter = TopRestaurantsNearAdapter(tt)
        rvTopRestaurantsNear.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = topRestaurantsNearAdapter
        }

    }

    override fun onClick(v: View?) {

    }

}





