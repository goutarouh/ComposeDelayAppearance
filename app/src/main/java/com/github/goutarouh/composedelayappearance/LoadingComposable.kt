package com.github.goutarouh.composedelayappearance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.debugInspectorInfo
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize().delayAppearance(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

fun Modifier.delayAppearance(
    delayMills: Long = 300L
) = composed(
    inspectorInfo = debugInspectorInfo {
        name = "delayAppearance"
        value = delayMills
    },
    factory = {
        var isShow by remember { mutableStateOf(false) }
        LaunchedEffect(Unit) {
            delay(delayMills)
            isShow = true
        }
        this.graphicsLayer {
            alpha = if (isShow) 1f else 0f
        }
    }
)


//@Composable
//fun LoadingScreen2(
//    delayMills: Long = 300L,
//    modifier: Modifier = Modifier
//) {
//
//    var isDisplay by remember { mutableStateOf(false) }
//
//    LaunchedEffect(Unit) {
//        delay(delayMills)
//        isDisplay = true
//    }
//
//    if (isDisplay) {
//        Box(
//            modifier = modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            CircularProgressIndicator()
//        }
//    }
//}