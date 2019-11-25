package com.example.starFoodDelivery.repositories.daos

import androidx.room.*
import com.example.starFoodDelivery.domain.entities.SavedAddresses
import io.reactivex.Observable


@Dao
interface SavedAddressesDao {
    @Query("SELECT * FROM saved_addresses")
    fun getAll(): Observable<MutableList<SavedAddresses>>

    @Query("SELECT * FROM saved_addresses WHERE type LIKE :type")
    fun findByType(type: Int): SavedAddresses

    @Insert
    fun insertAll(vararg todo: SavedAddresses)

    @Delete
    fun delete(todo: SavedAddresses)

    @Update
    fun updateAddress(vararg todos: SavedAddresses)

    @Query("UPDATE saved_addresses SET type=:type, address=:address, houseNumber=:houseNumber, city=:city, country=:country WHERE id=:id")
    fun update(id: Int, type: Int, address: String, houseNumber: String, city: String, country: String)

}