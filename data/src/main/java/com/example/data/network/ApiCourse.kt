package com.example.data.network

import com.example.domain.data.network.CourseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCourse {

    @GET("uc")
    suspend fun getCourses(
        @Query("id") fileId: String = "15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q",
        @Query("export") exportType: String = "download"
    ): Response<CourseResponse>
}