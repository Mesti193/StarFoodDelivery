package com.example.starFoodDelivery.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_addresses")
data class SavedAddresses(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int? = null,
    @ColumnInfo(name = "type") var type: Int,
    @ColumnInfo(name = "address") var address: String,
    @ColumnInfo(name = "houseNumber") var houseNumber: String,
    @ColumnInfo(name = "city") var city: String,
    @ColumnInfo(name = "country") var country: String
) {
    override fun toString(): String {
        return "SavedAddresses(id=$id, type=$type, address='$address', houseNumber='$houseNumber', city='$city', country='$country')"
    }
}