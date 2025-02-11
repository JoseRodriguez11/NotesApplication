package ui.mainScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import models.Notes


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navigateToNoteScreen: (Notes) -> Unit,
    viewModel: MainScreenViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            Toolbar(viewModel)
        },
        floatingActionButton = {

            FloatingButton(navigateToNoteScreen)
        }
    ) {
        NoteCard(viewModel, navigateToNoteScreen, it)


    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(viewModel: MainScreenViewModel) {
    TopAppBar(
        title = {
            Text(text = "Notes", fontSize = 30.sp, color = Color.Black)
        },
        actions = {
            IconButton(onClick = {
                viewModel.getAllNotes()
            }) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
            IconButton(onClick = {
                viewModel.getOnlyFavoriteNotes()
            }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
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
    val defaultNote = Notes(
        0,
        "",
        "",
        false,
    )
    FloatingActionButton(
        onClick = { navigateToAddNote(defaultNote) },
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
fun NoteCard(
    viewModel: MainScreenViewModel,
    navigateToNoteScreen: (Notes) -> Unit,
    paddingValues: PaddingValues
) {

    val notes = viewModel.listNotes.collectAsState().value
    val listState = viewModel.listState.collectAsState("")

    if (notes.isEmpty()){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = listState.value,
                modifier = Modifier
                    .fillMaxWidth()
                    ,
                color = Color.Gray,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
        }
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(paddingValues)

    ) {

        items(notes) { note ->
            ItemNote(note = note, navigateToNoteScreen)
        }


    }

}

@Composable
fun ItemNote(note: Notes, navigateToNoteScreen: (Notes) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(150.dp)
            .height(150.dp)
            .clickable { navigateToNoteScreen(note) },
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

