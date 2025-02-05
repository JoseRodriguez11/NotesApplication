package ui.noteScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import models.Notes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteScreen(notes: Notes, navigateBack: () -> Unit, viewModel: NoteViewModel = hiltViewModel()) {

    viewModel.passValues(notes)

    Scaffold(
        topBar = {
            ToolbarNotes(viewModel, navigateBack, notes)
        }

    ) {
        ContentNote(viewModel)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarNotes(viewModel: NoteViewModel, navigateBack: () -> Unit, note: Notes) {

    val uiState by viewModel.uiState.collectAsState()

    TopAppBar(
        title = {},

        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {
                    viewModel.addNote(
                        Notes(
                            note.id,
                            uiState.title,
                            uiState.note,
                            uiState.favorite
                        )
                    )
                    navigateBack()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
                IconButton(onClick = {
                    viewModel.deleteNote(note)
                    navigateBack()
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "delete",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }

                IconButton(onClick = {
                    viewModel.updateTextField(uiState.title, uiState.note, !uiState.favorite)
                }) {
                    if (uiState.favorite) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "add favorite",
                            tint = Color.Red,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.FavoriteBorder,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }

                }
            }
        }
    )
}


@Composable
fun ContentNote(viewModel: NoteViewModel) {

    val scrollState = rememberScrollState()
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 85.dp)
    ) {

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = uiState.title,
            onValueChange = { viewModel.updateTextField(it, uiState.note, uiState.favorite) },
            label = {
                Text(
                    text = "Title",

                    )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Black,
                focusedTextColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedLabelColor = Color.Black,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Black,
                fontSize = 22.sp
            )
        )


        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .verticalScroll(scrollState)
                .imePadding(),
            value = uiState.note,
            onValueChange = { viewModel.updateTextField(uiState.title, it, uiState.favorite) },
            label = {
                Text(
                    text = "Note",

                    )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = false,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Black,
                focusedTextColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedLabelColor = Color.Black,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp
            )
        )

    }
    LaunchedEffect(uiState.note) {
        scrollState.animateScrollTo(scrollState.maxValue)
    }
}


