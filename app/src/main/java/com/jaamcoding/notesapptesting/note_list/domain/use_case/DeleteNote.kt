package com.jaamcoding.notesapptesting.note_list.domain.use_case

import com.jaamcoding.notesapptesting.core.domain.model.NoteItem
import com.jaamcoding.notesapptesting.core.domain.repository.NoteRepository

class DeleteNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: NoteItem) {
        noteRepository.deleteNote(note)
    }

}