package com.example.presentation.screens.home.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.data.Course
import com.example.domain.usecases.GetCourseUsecase
import com.example.domain.usecases.GetSavedCourseIdsUseCase
import com.example.domain.usecases.ToggleBookmarkUseCase
import com.example.presentation.screens.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import okio.IOException
import java.time.LocalDate
import java.time.chrono.IsoChronology
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import javax.inject.Inject





@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCourseUseCase: GetCourseUsecase,
    private val getSavedCoursesUseCase: GetSavedCourseIdsUseCase,
    private val toggleBookmarkUseCase: ToggleBookmarkUseCase
) : ViewModel() {

    private val _networkCourses = MutableStateFlow<List<Course>>(emptyList())
    private val _isLoading = MutableStateFlow(false)
    private val _errorMessage = MutableStateFlow<String?>(null)
    private val _isSortByDateActive = MutableStateFlow(false)

    @RequiresApi(Build.VERSION_CODES.O)
    val uiState: StateFlow<HomeUiState> = combine(
        _networkCourses,
        getSavedCoursesUseCase(),
        _isLoading,
        _errorMessage,
        _isSortByDateActive
    ) { courses, savedCourses, isLoading, error, isSortActive ->
        when {
            error != null -> HomeUiState.Error(error)
            isLoading && courses.isEmpty() -> HomeUiState.Loading
            else -> {
                val finalCourses = if (isSortActive) {
                    // Создаем копию списка и сортируем по убыванию даты
                    courses.toMutableList().sortedByDescending { course ->
                        try {
                            LocalDate.parse(course.publishDate.trim())
                        } catch (e: Exception) {
                            Log.e("HomeViewModel", "Неверный формат даты в publishDate: ${course.publishDate}", e)
                            LocalDate.MIN
                        }
                    }
                } else {
                    courses.toList()
                }

                HomeUiState.Success(
                    courses = finalCourses,
                    savedIds = savedCourses.map { it.id }.toSet(),
                    isSortActive = isSortActive
                )
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeUiState.Loading
    )

    init {
        loadCourses()
    }

    fun toggleDateSorting() {
        _isSortByDateActive.value = !_isSortByDateActive.value
    }

    fun loadCourses() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                _networkCourses.value = getCourseUseCase()
            } catch (e: IOException) {
                _errorMessage.value = "Проверьте подключение к интернету"
            } catch (e: Exception) {
                _errorMessage.value = "Что-то пошло не так: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun toggleBookmark(course: Course, isSaved: Boolean) {
        viewModelScope.launch {
            toggleBookmarkUseCase(course, isSaved)
        }
    }
}