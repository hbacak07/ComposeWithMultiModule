package com.feature.movie_details.ui.screen

import android.graphics.Paint.Style
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun TvShowDetailsScreen(id: String, viewModel: TvShowDetailsViewModel) {
    val result = viewModel.tvShowDetails.value
    Scaffold(topBar = { TopAppBar(title = { Text(text = "TvShow Details") }) }) {
        Log.d("TvShowDetailsScreen", "TvShowDetailsScreen: $it")

        if (result.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        if (result.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = result.error)
            }
        }
        result.data?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                AsyncImage(
                    model = it.image_thumbnail_path,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(300.dp),
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier.fillMaxWidth()){
                    Text(text = it.name, style= MaterialTheme.typography.h5)
                    Text(text = it.description, style= MaterialTheme.typography.body1)

                }
            }
        }
    }
}
