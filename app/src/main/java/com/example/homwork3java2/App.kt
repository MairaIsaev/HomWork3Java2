package com.example.homwork3java2

import android.app.Application
import androidx.room.Room
import com.example.homwork3java2.room.AppDatabase

private const val DATABASE_NAME = "note-database"

class App: Application(){

    companion object{
        lateinit var db: AppDatabase
        private set
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

}