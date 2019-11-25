package com.example.starFoodDelivery.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.domain.entities.SavedAddresses
import com.example.starFoodDelivery.ui.fragment.SetDeliveryLocationFragment
import com.example.starFoodDelivery.util.formatText
import com.example.starFoodDelivery.util.inflate
import kotlinx.android.synthetic.main.item_saved_addresses.view.*

class SavedAddressesAdapter(private var savedAddresses: MutableList<SavedAddresses>, private val onClickEdit: ((SavedAddresses) -> Unit)? = null, private val onClickDelete: ((SavedAddresses) -> Unit)? = null) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder = Holder(parent.inflate(
        R.layout.item_saved_addresses, false))

    override fun getItemCount(): Int = savedAddresses.size

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as Holder).bind(savedAddresses[position], onClickEdit, onClickDelete)
    }

    class Holder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(item: SavedAddresses, onClickEdit: ((SavedAddresses) -> Unit)?, onClickDelete: ((SavedAddresses) -> Unit)?) {
            itemView.tvName.text = when(item.type){
                SetDeliveryLocationFragment.HOME -> "Home"
                SetDeliveryLocationFragment.OFFICE -> "Office"
                SetDeliveryLocationFragment.OTHER -> "Other"
                else -> "Other"
            }

            itemView.ivAddressType.setImageDrawable(when(item.type){
                SetDeliveryLocationFragment.HOME -> ContextCompat.getDrawable(itemView.context, R.drawable.ic_home_clicked)
                SetDeliveryLocationFragment.OFFICE -> ContextCompat.getDrawable(itemView.context, R.drawable.ic_cityscape)
                SetDeliveryLocationFragment.OTHER -> ContextCompat.getDrawable(itemView.context, R.drawable.ic_place)
                else -> ContextCompat.getDrawable(itemView.context, R.drawable.ic_place)
            })

            itemView.tvAddress.formatText(R.string.address_formatted, item.address, item.houseNumber, item.city, item.country)
            itemView.tvEdit.setOnClickListener{onClickEdit?.invoke(item)}
            itemView.tvDelete.setOnClickListener{onClickDelete?.invoke(item)}
        }
    }
}