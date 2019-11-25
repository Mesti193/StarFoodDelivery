package com.example.starFoodDelivery.repositories.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.starFoodDelivery.domain.entities.SavedAddresses
import com.example.starFoodDelivery.repositories.daos.SavedAddressesDao

@Database(
    entities = [SavedAddresses::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun SavedAddressesDao(): SavedAddressesDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "star-food-delivery.db")
            .build()
    }
}