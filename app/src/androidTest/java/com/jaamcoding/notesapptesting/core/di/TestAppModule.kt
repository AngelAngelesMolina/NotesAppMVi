package com.jaamcoding.notesapptesting.core.di

import android.app.Application
import androidx.room.Room
import com.jaamcoding.notesapptesting.core.data.local.NoteDb
import com.jaamcoding.notesapptesting.core.data.repository.FakeAndroidNoteRepository
import com.jaamcoding.notesapptesting.core.domain.repository.NoteRepository
import com.jaamcoding.notesapptesting.note_list.domain.use_case.DeleteNote
import com.jaamcoding.notesapptesting.note_list.domain.use_case.GetAllNotes
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

    @Provides
    @Singleton
    fun provideGetAllNotesUseCase(noteRepository: NoteRepository): GetAllNotes {
        return GetAllNotes(noteRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteNoteUseCase(noteRepository: NoteRepository): DeleteNote {
        return DeleteNote(noteRepository)
    }


}