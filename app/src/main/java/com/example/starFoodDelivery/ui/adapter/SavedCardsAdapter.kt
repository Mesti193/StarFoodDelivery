package com.example.starFoodDelivery.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.starFoodDelivery.R
import com.example.starFoodDelivery.util.afterTextChanged
import com.example.starFoodDelivery.util.inflate
import kotlinx.android.synthetic.main.item_saved_cards.view.*

class SavedCardsAdapter(private var isEditPaymentMethodsSection: Boolean? = false, private var savedCards: MutableList<String>, private val onClickEdit: ((String) -> Unit)? = null, private val onClickMakePayment: ((String) -> Unit)? = null) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder = Holder(parent.inflate(
        R.layout.item_saved_cards, false))

    override fun getItemCount(): Int = savedCards.size

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as Holder).bind(isEditPaymentMethodsSection, savedCards[position], onClickEdit, onClickMakePayment)
    }

    class Holder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(isEditPaymentMethodsSection: Boolean?, item: String, onClickEdit: ((String) -> Unit)?, onClickMakePayment: ((String) -> Unit)?) {

            if(isEditPaymentMethodsSection != null && isEditPaymentMethodsSection){
                itemView.btMakePayment.text = "Edit"
                itemView.etCvv.visibility = View.INVISIBLE
            }else{
                itemView.btMakePayment.text = "Make payment"
                itemView.etCvv.visibility = View.VISIBLE
                itemView.etCvv.afterTextChanged { validate() }
            }


        }

        private fun validate(){
            val cvv: Boolean = itemView.etCvv.text.length == 3

            itemView.btMakePayment?.apply {
                if(cvv){
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
    }

}