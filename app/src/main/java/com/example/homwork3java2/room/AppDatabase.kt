package com.example.homwork3java2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homwork3java2.room.doa.NoteDao
import com.example.homwork3java2.room.entities.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun nateDao(): NoteDao

}