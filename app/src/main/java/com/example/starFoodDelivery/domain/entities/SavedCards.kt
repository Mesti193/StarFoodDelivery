package com.example.starFoodDelivery.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_cards")
data class SavedCards(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int? = null,
    @ColumnInfo(name = "cardNumber") var cardNumber: Long,
    @ColumnInfo(name = "validThru") var validThru: String,
    @ColumnInfo(name = "cvv") var cvv: Int,
    @ColumnInfo(name = "nameOnCard") var nameOnCard: String,
    @ColumnInfo(name = "isSecurelySaved") var isSecurelySaved: Boolean
) {
}