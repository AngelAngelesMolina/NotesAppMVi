package com.jaamcoding.notesapptesting.core.domain.repository

import com.jaamcoding.notesapptesting.core.domain.model.NoteItem

interface NoteRepository {

    suspend fun upsertNote(noteItem: NoteItem)

    suspend fun deleteNote(noteItem: NoteItem)

    suspend fun getAllNotes(): List<NoteItem>

}