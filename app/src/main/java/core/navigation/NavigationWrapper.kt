package core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import core.navigation.type.createNavType
import models.Notes
import ui.mainScreen.MainScreen
import ui.noteScreen.NoteScreen
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = MainScreen ){
        composable<MainScreen>{
            MainScreen{ navController.navigate(Note(it))}
        }
        composable<Note> (typeMap = mapOf(typeOf<Notes>() to createNavType<Notes>())){ backStackEntry ->
            val note = backStackEntry.toRoute<Note>()
            NoteScreen(note.notes)
        }
    }
}