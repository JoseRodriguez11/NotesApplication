package com.example.note.ui.theme.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import models.Notes

@Dao
interface NotesDataBaseDao {

    @Query("SELECT * FROM notes_tbl")
    fun getNotes(): Flow<List<Notes>>

    @Query("SELECT * FROM notes_tbl WHERE favorite = TRUE")
    fun getOnlyFavoriteNotes(): Flow<List<Notes>>

    @Query("SELECT * FROM notes_tbl WHERE id = :id")
    suspend fun getNoteById(id:String): Notes

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertNote(nota:Notes)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(nota: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)


}