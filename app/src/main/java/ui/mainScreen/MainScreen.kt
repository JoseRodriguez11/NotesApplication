package ui.mainScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import models.Notes


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navigateToNoteScreen: (Notes) -> Unit,
    viewModel: MainScreenViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            Toolbar()
        },
        floatingActionButton = {

            FloatingButton(navigateToNoteScreen)
        }
    ) {
        NoteCard(viewModel)
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Text(text = "Notes", fontSize = 30.sp, color = Color.Black)
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }


    )
}

@Composable
fun FloatingButton(navigateToAddNote: (Notes) -> Unit) {
    val defaulNote = Notes(
        0,
        "este es el titulo",
        "hola como estas esta es la nota que envio desde navgacio",
        false,
    )
    FloatingActionButton(
        onClick = { navigateToAddNote(defaulNote) },
        contentColor = Color.White,
        containerColor = Color.Black
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Note"

        )
    }
}

@Composable
fun NoteCard(viewModel: MainScreenViewModel) {

    val notes = viewModel.listNotes.collectAsState().value

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(top = 85.dp)

    ) {
        items(notes) { note ->
            ItemNote(note = note)
        }

    }

}

@Composable
fun ItemNote(note: Notes) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(150.dp)
            .height(150.dp)
            .clickable { },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
        ) {
            Text(
                text = note.title,
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            Text(
                text = note.note,
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
            )



            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically


            ) {

                if (note.favorite) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier
                            .size(15.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(15.dp)
                    )
                }

                Text(
                    text = note.date,
                    fontSize = 8.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                )


            }

        }
    }
}

