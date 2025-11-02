package com.jaamcoding.notesapptesting.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jaamcoding.notesapptesting.core.presentation.ui.theme.NotesAppTestingTheme
import com.jaamcoding.notesapptesting.note_list.presentation.NoteListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTestingTheme {
                Navigation()
            }
        }
    }
}
@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.NoteList
    ) {

        composable<Screen.NoteList> {
            NoteListScreen(
                onNavigateToAddNote = {

                    //navController.navigate(Screen.AddNote)
                }
            )
        }

        /*composable<Screen.AddNote> {
            AddNoteScreen(
                onSave = {
                    navController.popBackStack()
                }
            )
        }*/
    }
}