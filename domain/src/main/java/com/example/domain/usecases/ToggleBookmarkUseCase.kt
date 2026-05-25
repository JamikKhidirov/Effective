package com.example.domain.usecases

import com.example.domain.data.Course
import com.example.domain.repository.CourseRepository
import javax.inject.Inject




class ToggleBookmarkUseCase @Inject constructor(private val repository: CourseRepository) {
    suspend operator fun invoke(course: Course, isSaved: Boolean) {
        if (isSaved) {
            repository.deleteCourse(course)
        } else {
            repository.saveCourse(course)
        }
    }
}