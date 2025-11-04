package com.jaamcoding.notesapptesting.add_note.domain.use_case

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.jaamcoding.notesapptesting.MainCoroutineRule
import com.jaamcoding.notesapptesting.core.data.repository.FakeNoteRepository
import com.jaamcoding.notesapptesting.note_list.domain.use_case.DeleteNote
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class UpsertNoteTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var fakeNoteRepositoryImpl: FakeNoteRepository
    private lateinit var upsertNote: UpsertNote

    @Before
    fun setUp() {
        fakeNoteRepositoryImpl = FakeNoteRepository()
        upsertNote = UpsertNote(fakeNoteRepositoryImpl)
    }

    @Test
    fun `upsert note with empty title, return false`() = runTest {
        val isInserted = upsertNote.invoke("", "desc", "url")
        assertThat(isInserted).isFalse()
    }

    @Test
    fun `upsert note with empty description, return false`() = runTest {
        val isInserted = upsertNote.invoke("title", "", "url")
        assertThat(isInserted).isFalse()
    }

    @Test
    fun `upsert a valid note, return true`() = runTest {
        val isInserted = upsertNote.invoke("title", "desc", "url")
        assertThat(isInserted).isTrue()
    }


}