package com.jaamcoding.notesapptesting.core.di

import android.app.Application
import androidx.room.Room
import com.jaamcoding.notesapptesting.add_note.domain.use_case.UpsertNote
import com.jaamcoding.notesapptesting.core.data.local.NoteDb
import com.jaamcoding.notesapptesting.core.data.repository.NoteRepositoryImpl
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
object AppModule {

    @Provides
    @Singleton
    fun proviteNotesDb(application: Application): NoteDb {
        return Room.databaseBuilder(application, NoteDb::class.java, "note_db.db").build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDb: NoteDb): NoteRepository {
        return NoteRepositoryImpl(noteDb)
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

    @Provides
    @Singleton
    fun provideUpsertNoteUseCase(noteRepository: NoteRepository) : UpsertNote{
        return UpsertNote(noteRepository)
    }

}