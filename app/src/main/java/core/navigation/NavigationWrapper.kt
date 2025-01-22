package core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import ui.MainScreen
import ui.NoteScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = MainScreen ){
        composable<MainScreen>{
            MainScreen{ title,note -> navController.navigate(Note(title = title , note = note ))}
        }
        composable<Note> {
            val note = it.toRoute<Note>()
            NoteScreen(note.title, note.note)
        }
    }
}