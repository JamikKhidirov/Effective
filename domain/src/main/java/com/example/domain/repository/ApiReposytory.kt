package com.example.domain.repository

import com.example.domain.data.Course


interface ApiRepository {

    suspend fun getAllCourse(): List<Course>
}