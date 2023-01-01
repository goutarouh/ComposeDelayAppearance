package com.github.goutarouh.composedelayappearance.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class DetailViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(DetailScreenUiState())
    val uiState = _uiState.asStateFlow()

    init {
        dummyFetchSomething()
    }

    private fun dummyFetchSomething() {

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val delayMills = if (Random.nextBoolean()) 300L else 2000L
            delay(delayMills)
            _uiState.update {
                it.copy(isLoading = false, delayMills = delayMills)
            }
        }

    }

}