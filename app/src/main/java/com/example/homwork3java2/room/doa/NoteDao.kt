package com.example.homwork3java2.room.doa

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.homwork3java2.room.entities.Note
import androidx.room.OnConflictStrategy.Companion as OnConflictStrategy1

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNotes(note:List<Note>)

    @Delete
    fun deleteNote(note: Note)

    @Query("DELETE FROM note_table")
    fun clear()

}