package com.example.note.ui.theme.di

import android.content.Context
import androidx.room.Room
import com.example.note.ui.theme.data.NotesDataBaseDao
import com.example.note.ui.theme.data.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): NotesDatabase =
        Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            "notes_bd",

            ).fallbackToDestructiveMigrationFrom()
            .build()


    @Singleton
    @Provides
    fun provideNotesDao(notesDataBase: NotesDatabase): NotesDataBaseDao = notesDataBase.notaDao()
}