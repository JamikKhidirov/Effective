package com.example.presentation.screens.home

import com.example.domain.data.Course


sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(
        val courses: List<Course>,
        val savedIds: Set<Int>,
        val isSortActive: Boolean
    ) : HomeUiState
    data class Error(val message: String) : HomeUiState
}