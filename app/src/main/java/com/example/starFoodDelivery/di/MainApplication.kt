package com.example.starFoodDelivery.di

import android.app.Application
import androidx.room.Room
import com.example.starFoodDelivery.repositories.database.AppDatabase
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    companion object{
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "star-food-delivery.db"
        ).build()
        startKoin(this, listOf(appModule))
    }
}