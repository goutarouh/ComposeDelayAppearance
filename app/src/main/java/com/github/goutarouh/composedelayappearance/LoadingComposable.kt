package com.github.goutarouh.composedelayappearance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    delayMills: Long = 300L,
    modifier: Modifier = Modifier
) {

    var isDisplay by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(delayMills)
        isDisplay = true
    }

    if (isDisplay) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}