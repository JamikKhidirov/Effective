package com.example.domain.usecases

import com.example.domain.data.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class GetSavedCourseIdsUseCase @Inject constructor(
    private val repository: CourseRepository
){

    operator  fun invoke(): Flow<List<Course>> = repository.getSavedCourses()
}