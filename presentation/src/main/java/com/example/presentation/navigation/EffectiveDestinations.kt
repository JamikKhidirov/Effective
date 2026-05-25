package com.example.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
object AuthRoute


@Serializable
object HomeRoute

@Serializable
object SavedRoute

@Serializable
object AccountRoute

@Serializable
data class DetailRoute(val courseId: Int)