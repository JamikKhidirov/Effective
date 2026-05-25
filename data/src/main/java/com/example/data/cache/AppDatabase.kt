package com.example.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [CourseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}