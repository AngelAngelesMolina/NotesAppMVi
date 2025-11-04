package com.jaamcoding.notesapptesting.add_note.domain.use_case

import com.jaamcoding.notesapptesting.core.domain.model.NoteItem
import com.jaamcoding.notesapptesting.core.domain.repository.NoteRepository

class UpsertNote(private val noteRepository: NoteRepository) {


    suspend operator fun invoke(title: String, description: String, imageUrl: String): Boolean {

        if (title.isEmpty() || description.isEmpty()) {
            return false
        }
        noteRepository.upsertNote(
            NoteItem(
                title,
                description,
                dateAdded = System.currentTimeMillis(),
                imageUrl = imageUrl
            )
        )
        return true

    }
}