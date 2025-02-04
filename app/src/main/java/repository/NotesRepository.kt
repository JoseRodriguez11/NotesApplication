package com.example.note.ui.theme.repository

import com.example.note.ui.theme.data.NotesDataBaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import models.Notes
import javax.inject.Inject

class NotesRepository @Inject constructor(
    private val notesDataBaseDao: NotesDataBaseDao
) {

    suspend fun addNote(note: Notes) = notesDataBaseDao.insertNote(note)
    suspend fun updateNote(note: Notes) = notesDataBaseDao.updateNote(note)
    suspend fun deleteNote(note: Notes) = notesDataBaseDao.deleteNote(note)

    fun getAllNotes(): Flow<List<Notes>> =
        notesDataBaseDao.getNotes().flowOn(Dispatchers.IO).conflate()

}