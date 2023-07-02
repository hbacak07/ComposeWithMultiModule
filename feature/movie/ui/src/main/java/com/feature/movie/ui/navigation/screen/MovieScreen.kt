package com.feature.movie.ui.navigation.screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieScreen(viewModel: MovieViewModel,navController: NavController) {
    val result = viewModel.movieList.value
    val query = viewModel.query.collectAsState()

    Scaffold(topBar = {
        TextField(modifier = Modifier.fillMaxWidth(),value = query.value, onValueChange = {
            viewModel.setLoadPage(it.trim().toInt())
        },
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ), placeholder = {
            Text(text = "Search Page...")
            }, trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null)}
            )
    }) {
        Log.d("MovieScreen", "MovieScreen: $it")

        if (result.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        if (result.message.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = result.message)
            }
        }

        result.data?.let {
            if (it.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Nothing Found")
                }
            } else {
                LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp), content = {
                    items(it) {
                        Box(
                            modifier = Modifier
                                .height(200.dp)
                                .border(width = 1.dp, color = Color.White)
                        ) {
                            AsyncImage(
                                modifier = Modifier.clickable {
                                    navController.navigate("tv_shows_details_screen_route/${it.id}")
                                } ,
                                model = it.image_thumbnail_path,
                                contentDescription = null,
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                })
            }
        }
    }
}