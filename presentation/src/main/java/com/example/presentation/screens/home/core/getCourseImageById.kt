package com.example.presentation.screens.home.core

import androidx.annotation.DrawableRes
import com.example.presentation.R


@DrawableRes
fun getCourseImageById(id: Int): Int {
    return when (id) {
        100 -> R.drawable.java       // твоя картинка в drawable
        101 -> R.drawable.jeneralis
        102 -> R.drawable.injener
        else -> R.drawable.java // дефолтная заглушка
    }
}
