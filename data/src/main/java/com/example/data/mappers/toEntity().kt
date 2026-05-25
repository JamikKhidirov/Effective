package com.example.data.mappers

import com.example.data.cache.CourseEntity
import com.example.domain.data.Course


fun Course.toEntity() = CourseEntity(id, title, text, price, rate, startDate, hasLike, publishDate)