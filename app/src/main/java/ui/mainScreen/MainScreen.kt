package ui.mainScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.Notes


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen( navigateToNoteScreen:(Notes) -> Unit ){
    Scaffold (
        topBar = {
            Toolbar()
        },
        floatingActionButton = {

            FloatingButton( navigateToNoteScreen)
        }
    ){
        NoteCard()
    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(){
    TopAppBar(
        title = {
            Text(text = "Notes" , fontSize = 30.sp, color = Color.Black )
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
fun FloatingButton(navigateToAddNote: (Notes) -> Unit){
    val defaulNote = Notes("este es el titulo","hola como estas esta es la nota que envio desde navgacio",false)
    FloatingActionButton(onClick = { navigateToAddNote (defaulNote)}, contentColor = Color.White, containerColor = Color.Black) {
        Icon(
            imageVector = Icons.Default.Add ,
            contentDescription = "Add Note"

        )
    }
}

@Composable
fun NoteCard(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(top = 85.dp)

    ) {
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp)
                    .clickable {  },
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp),
            ){
                Text(
                    text = "primera card",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = Color.Black
                )
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
            ){
                Text(
                    text = "primera card",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    color = Color.Black
                )
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
            ){
                Text(
                    text = "primera card",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    color = Color.Black
                )
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
            ){
                Text(
                    text = "primera card",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    color = Color.Black
                )
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
            ){
                Text(
                    text = "primera card",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    color = Color.Black
                )
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
            ){
                Text(
                    text = "primera card",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    color = Color.Black
                )
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
            ){
                Text(
                    text = "primera card",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    color = Color.Black
                )
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
            ){
                Text(
                    text = "primera card",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    color = Color.Black
                )
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
            ){
                Text(
                    text = "primera card",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    color = Color.Black
                )
            }
        }


    }

}