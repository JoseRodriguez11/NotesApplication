package com.example.note.ui.theme.data

import androidx.room.Database
import androidx.room.RoomDatabase
import models.Notes

@Database(
    entities = [Notes::class],
    version = 1, exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notaDao() : NotesDataBaseDao

}