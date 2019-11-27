package com.example.starFoodDelivery.repositories.daos

import androidx.room.*
import com.example.starFoodDelivery.domain.entities.SavedCards
import io.reactivex.Observable

@Dao
interface SavedCardsDao {
    @Query("SELECT * FROM saved_cards")
    fun getAll(): Observable<MutableList<SavedCards>>

    @Insert
    fun insertAll(vararg todo: SavedCards)

    @Delete
    fun delete(todo: SavedCards)

    @Update
    fun updateAddress(vararg todos: SavedCards)

    @Query("UPDATE saved_cards SET cardNumber=:cardNumber, validThru=:validThru, cvv=:cvv, nameOnCard=:nameOnCard, isSecurelySaved=:isSecurelySaved WHERE id=:id")
    fun update(id: Int, cardNumber: Long, validThru: String, cvv: Int, nameOnCard: String, isSecurelySaved: Boolean)

}
