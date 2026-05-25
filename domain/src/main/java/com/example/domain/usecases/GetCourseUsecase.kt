package com.example.domain.usecases

import com.example.domain.data.Course
import com.example.domain.repository.ApiRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetCourseUsecase @Inject constructor(
    private val repository: ApiRepository
){
    suspend operator fun invoke(): List<Course>{
        return repository.getAllCourse()
    }
}