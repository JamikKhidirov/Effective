package com.example.data.di

import com.example.data.implementationrepository.ApiRepositoryImpl
import com.example.data.implementationrepository.CourseRepositoryImpl
import com.example.domain.repository.ApiRepository
import com.example.domain.repository.CourseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindApiRepository(
        apiRepositoryImpl: ApiRepositoryImpl
    ): ApiRepository

    @Binds
    @Singleton
    abstract fun bindCourseRepository(
        repositoryImpl: CourseRepositoryImpl
    ): CourseRepository
}