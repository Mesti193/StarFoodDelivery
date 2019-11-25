package com.example.starFoodDelivery.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.util.inflate
import com.example.starFoodDelivery.util.showELog
import kotlinx.android.synthetic.main.item_saved_addresses.view.*

class SavedAddressesAdapter(private var savedAddresses: MutableList<String>, private val onClickEdit: ((String) -> Unit)? = null, private val onClickDelete: ((String) -> Unit)? = null) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder = Holder(parent.inflate(
        R.layout.item_saved_addresses, false))

    override fun getItemCount(): Int = savedAddresses.size

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as Holder).bind(savedAddresses[position], onClickEdit, onClickDelete)
    }

    class Holder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(item: String, onClickEdit: ((String) -> Unit)?, onClickDelete: ((String) -> Unit)?) {
            itemView.tvName.text = "Work"
            itemView.tvAddress.text = "393, Seventh street, durga nagar, Maletioist near lax road, malhar point, mumbai"

            itemView.tvEdit.setOnClickListener{onClickEdit?.invoke(item)}
            itemView.tvDelete.setOnClickListener{onClickDelete?.invoke(item)}
        }
    }
}