package com.example.starFoodDelivery.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starFoodDelivery.R
import kotlinx.android.synthetic.main.item_top_restaurants_near.view.*

class TopRestaurantsNearAdapter(private var topRestaurantsList: MutableList<String>): RecyclerView.Adapter<TopRestaurantsNearAdapter.TopRestaurantsNearHolder>() {

    override fun getItemCount(): Int = topRestaurantsList.size

    override fun onBindViewHolder(holder: TopRestaurantsNearHolder, position: Int) = holder.run {
        bind(topRestaurantsList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRestaurantsNearHolder = TopRestaurantsNearHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_top_restaurants_near, parent, false))

    class TopRestaurantsNearHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) = with(itemView) {

            tvRestaurantName?.text = item
            tvRestaurantType?.text = item
            tvRestaurantArea?.text = item

            tvStars?.text = "4.6"
            tvDeliverIn?.text = item

        }
    }

}