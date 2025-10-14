package com.jaamcoding.notesapptesting.core.data.repository

import com.jaamcoding.notesapptesting.core.data.local.NoteDao
import com.jaamcoding.notesapptesting.core.data.local.NoteDb
import com.jaamcoding.notesapptesting.core.data.mapper.toNoteEntityForDelete
import com.jaamcoding.notesapptesting.core.data.mapper.toNoteEntityForInsert
import com.jaamcoding.notesapptesting.core.data.mapper.toNoteItem
import com.jaamcoding.notesapptesting.core.domain.model.NoteItem
import com.jaamcoding.notesapptesting.core.domain.repository.NoteRepository

class NoteRepositoryImpl(
    notedb: NoteDb
) : NoteRepository {

    private val noteDao = notedb.noteDao

    override suspend fun upsertNote(noteItem: NoteItem) {
        noteDao.upsertNoteEntity(noteItem.toNoteEntityForInsert())
    }

    override suspend fun deleteNote(noteItem: NoteItem) {
        noteDao.deleteNoteEntity(noteItem.toNoteEntityForDelete())
    }

    override suspend fun getAllNotes(): List<NoteItem> {
        return noteDao.getAllNoteEntities().map { it.toNoteItem() }
    }
}