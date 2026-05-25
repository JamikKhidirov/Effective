package com.example.domain.repository

import com.example.domain.data.Course
import kotlinx.coroutines.flow.Flow


interface CourseRepository {

    // Получение курсов из сети
    suspend fun getNetworkCourses(): List<Course>

    // Работа с локальным кэшем закладок
    fun getSavedCourses(): Flow<List<Course>>
    suspend fun saveCourse(course: Course)
    suspend fun deleteCourse(course: Course)
}