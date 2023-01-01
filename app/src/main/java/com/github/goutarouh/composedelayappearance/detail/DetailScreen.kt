package com.github.goutarouh.composedelayappearance.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.goutarouh.composedelayappearance.LoadingScreen

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = viewModel()
) {

    val uiState = viewModel.uiState.collectAsState()

    when {
        uiState.value.isLoading -> {
            LoadingScreen()
        }
        else -> {
            DetailContents(uiState.value)
        }
    }
}

@Composable
fun DetailContents(
    uiState: DetailScreenUiState
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "DetailScreen took ${uiState.delayMills}ms to display.")
    }
}