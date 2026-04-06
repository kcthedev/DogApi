package com.kcthomas.dogapi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 48.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f)
        ) {
            val urls = viewState.imageUrls
            items(urls) { url ->
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    model = url,
                    placeholder = painterResource(id = R.drawable.ic_placeholder),
                    error = painterResource(id = R.drawable.ic_error),
                    contentDescription = "Dog Image"
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = viewModel::loadDogs) {
            Text("Get Dogs")
        }
    }
}
