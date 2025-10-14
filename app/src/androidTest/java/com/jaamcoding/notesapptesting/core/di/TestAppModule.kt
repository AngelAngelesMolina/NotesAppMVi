package com.jaamcoding.notesapptesting.core.di

import android.app.Application
import androidx.room.Room
import com.jaamcoding.notesapptesting.core.data.local.NoteDb
import com.jaamcoding.notesapptesting.core.data.repository.FakeAndroidNoteRepository
import com.jaamcoding.notesapptesting.core.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun proviteNotesDb(application: Application): NoteDb {
        return Room.inMemoryDatabaseBuilder(application, NoteDb::class.java).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(): NoteRepository {
        return FakeAndroidNoteRepository()
    }


}