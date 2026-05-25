package com.example.presentation.screens.home.uicomponents.bottombar


data class BottomBarData<T>(
    val text: String,
    val icon: Int,
    val route: T
)