package com.example.note.ui.theme.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){

    Scaffold (
        topBar = {
            Toolbar()
        },
        floatingActionButton = {
            FloatingButton()
        }
    ){
        Notes()
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
fun FloatingButton(){
    FloatingActionButton(onClick = {}, contentColor = Color.White, containerColor = Color.Black) {
        Icon(
            imageVector = Icons.Default.Add ,
            contentDescription = "Add"

        )
    }
}

@Composable
fun Notes(){

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(top = 70.dp)

    ) {
        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp),
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