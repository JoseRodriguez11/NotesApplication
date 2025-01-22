package ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun NoteScreen(title: String, note: String){

    Text(text = "TITLE: $title Note: $note" , fontSize = 30.sp, color = Color.Black )

}