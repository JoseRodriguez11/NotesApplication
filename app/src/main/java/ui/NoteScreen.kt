package ui

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteScreen(title: String, note: String) {

    Scaffold(
        topBar = {
            ToolbarNotes()
        }

    ) {
        ContentNote(title, note)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarNotes() {
    TopAppBar(
        title = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        },

        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    )
}


@Composable
fun ContentNote(title: String, note: String) {

    var note by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 85.dp)
    ) {

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = title,
            onValueChange = {},
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
            value = note,
            onValueChange = { note = it },
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
    LaunchedEffect(note) {
        scrollState.animateScrollTo(scrollState.maxValue)
    }
}


