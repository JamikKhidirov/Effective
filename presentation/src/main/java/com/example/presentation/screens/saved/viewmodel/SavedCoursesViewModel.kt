package com.example.presentation.screens.saved.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.data.Course
import com.example.domain.usecases.GetSavedCourseIdsUseCase
import com.example.domain.usecases.ToggleBookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SavedCoursesViewModel @Inject constructor(
    private val getSavedCoursesUseCase: GetSavedCourseIdsUseCase,
    private val toggleBookmarkUseCase: ToggleBookmarkUseCase
) : ViewModel() {

    // Слушаем базу данных в реальном времени.
    // Если пользователь удалит курс из избранного экран обновится автоматически
    val savedCourses: StateFlow<List<Course>> = getSavedCoursesUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun removeFromBookmark(course: Course) {
        viewModelScope.launch {
            toggleBookmarkUseCase(course, isSaved = true)
        }
    }
}