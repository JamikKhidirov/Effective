package com.example.data.implementationrepository

import com.example.data.cache.CourseDao
import com.example.data.mappers.toDomain
import com.example.data.mappers.toDomainCourses
import com.example.data.mappers.toEntity
import com.example.data.network.ApiCourse
import com.example.domain.data.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CourseRepositoryImpl @Inject constructor(
    private val apiService: ApiCourse,
    private val courseDao: CourseDao
) : CourseRepository {

    override suspend fun getNetworkCourses(): List<Course> {
        // Безопасный вызов: если body() или courses равен null, вернется пустой список
        return apiService.getCourses().body()?.courses?.map { it.toDomainCourses() } ?: emptyList()
    }

    override fun getSavedCourses(): Flow<List<Course>> {
        return courseDao.getAllSavedCourses().map { entityList ->
            // Превращаем каждую CourseEntity из базы данных в доменный Course
            entityList.map { it.toDomain() }
        }
    }

    override suspend fun saveCourse(course: Course) {
        courseDao.insertCourse(course.toEntity())
    }

    override suspend fun deleteCourse(course: Course) {
        courseDao.deleteCourse(course.toEntity())
    }
}