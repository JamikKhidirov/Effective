package com.example.data.mappers

import com.example.domain.data.Course
import com.example.domain.data.network.CourseDto


fun CourseDto.toDomainCourses(): Course {
    return Course(
        id = this.id,
        title = this.title,
        text = this.text,
        price = this.price,
        rate = this.rate,
        startDate = this.startDate,
        hasLike = this.hasLike,
        publishDate = this.publishDate
    )
}