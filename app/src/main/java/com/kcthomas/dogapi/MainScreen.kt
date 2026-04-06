package com.kcthomas.dogapi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val viewState by viewModel.viewState.collectAsState()
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        AsyncImage(
//            modifier = Modifier.size(300.dp),
//            model = viewState.imageUrl,
//            placeholder = painterResource(id = R.drawable.ic_placeholder),
//            error = painterResource(id = R.drawable.ic_error),
//            contentDescription = "Dog Image"
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = viewModel::loadDog) {
//            Text("Get Dog")
//        }
//    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ) {
            val urls = viewState.imageUrls
            items(urls) { url ->
                // Your individual grid item UI goes here
                AsyncImage(
                    modifier = Modifier.size(300.dp),
                    model = url,
                    placeholder = painterResource(id = R.drawable.ic_placeholder),
                    error = painterResource(id = R.drawable.ic_error),
                    contentDescription = "Dog Image"
                )
            }
        }
        Button(onClick = viewModel::loadDogs) {
            Text("Get Dogs")
        }
    }
}
