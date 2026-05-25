package com.example.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey





@Entity(tableName = "saved_courses")
data class CourseEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
)

