package com.example.starFoodDelivery.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.util.inflate

class SavedCardsAdapter(private var savedCards: MutableList<String>, private val onClickEdit: ((String) -> Unit)? = null, private val onClickDelete: ((String) -> Unit)? = null) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder = Holder(parent.inflate(
        R.layout.item_saved_cards, false))

    override fun getItemCount(): Int = savedCards.size

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as Holder).bind(savedCards[position], onClickEdit, onClickDelete)
    }

    class Holder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(item: String, onClickEdit: ((String) -> Unit)?, onClickDelete: ((String) -> Unit)?) {



        }
    }
}