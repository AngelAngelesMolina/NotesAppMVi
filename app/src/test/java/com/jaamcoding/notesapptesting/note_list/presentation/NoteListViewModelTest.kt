package com.jaamcoding.notesapptesting.note_list.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jaamcoding.notesapptesting.core.data.repository.FakeNoteRepository
import com.jaamcoding.notesapptesting.note_list.domain.use_case.DeleteNote
import com.jaamcoding.notesapptesting.note_list.domain.use_case.GetAllNotes
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import com.jaamcoding.notesapptesting.MainCoroutineRule
import com.jaamcoding.notesapptesting.core.domain.model.NoteItem


class NoteListViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var fakeNoteRepository: FakeNoteRepository
    private lateinit var getAllNotes: GetAllNotes
    private lateinit var deleteNote: DeleteNote

    private lateinit var noteListViewModel: NoteListViewModel

    @Before
    fun setUp() {
        fakeNoteRepository = FakeNoteRepository()
        deleteNote = DeleteNote(fakeNoteRepository)
        getAllNotes = GetAllNotes(fakeNoteRepository)
        noteListViewModel = NoteListViewModel(getAllNotes, deleteNote)

    }

    @Test
    fun `get notes from an empty list, note list is empty`() = runTest {
        fakeNoteRepository.shouldHaveFilledList(false)
        noteListViewModel.loadNotes()
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
        assertThat(noteListViewModel.noteListState.value.isEmpty()).isTrue()
    }

    @Test
    fun `get notes from a filled list, note list is not empty`() = runTest {
        fakeNoteRepository.shouldHaveFilledList(true)
        noteListViewModel.loadNotes()
        //need to wait until it does the function
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
        assertThat(noteListViewModel.noteListState.value.isNotEmpty()).isTrue()
    }

    @Test
    fun `delete note from list, note list is deleted`() = runTest {
        fakeNoteRepository.shouldHaveFilledList(true)
        noteListViewModel.loadNotes() //Adding first the notes to our state
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
        val note = NoteItem("c title 2", "desc 2", "url2", 2)
        noteListViewModel.deleteNote(note) //Deleting items
        //need to wait until it does the function
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
        assertThat(noteListViewModel.noteListState.value.contains(note)).isFalse() // Expect the result
    }

}