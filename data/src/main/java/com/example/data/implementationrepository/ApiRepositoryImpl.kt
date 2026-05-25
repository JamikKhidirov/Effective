package com.example.data.implementationrepository

import com.example.data.mappers.toDomainCourses
import com.example.data.network.ApiCourse
import com.example.domain.data.Course
import com.example.domain.repository.ApiRepository
import okio.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepositoryImpl @Inject constructor(
    private val courseApi: ApiCourse
): ApiRepository {

    override suspend fun getAllCourse(): List<Course> {
        try {
            val response = courseApi.getCourses()
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null) {
                    return data.courses.map { it.toDomainCourses() }
                }

            }
            // 4. Если сервер вернул ошибку (например, 500) или боди пустой, кидаем ошибку
            throw okio.IOException("Ошибка загрузки данных: ${response.code()} ${response.message()}")
        } catch (e: IOException) {

        } finally {

        }
        return emptyList()
    }
}