package com.example.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.screens.home.HomeScreen
import com.example.presentation.screens.login.LogInScreen
import com.example.presentation.screens.saved.SavedCoursesScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    navController: NavHostController
) {


    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AuthRoute, // Передаем объект стартового экрана
            modifier = Modifier.fillMaxSize()
        ) {

            composable<AuthRoute> {
                LogInScreen(
                     navHostController = navController,
                 )
            }
            // Экран Главной
            composable<HomeRoute> {
                HomeScreen(
                    navHostController = navController,
                    onDetailClick = { course ->// Передаем ID курса в безопасный маршрут
                        navController.navigate(DetailRoute(courseId = course.id))
                    }
                )
            }

            // Экран Избранного
            composable<SavedRoute> {
                SavedCoursesScreen(
                    navHostController = navController,
                    onDetailClick = { course ->
                        navController.navigate(DetailRoute(courseId = course.id)){
                            popUpTo<AuthRoute> {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            // Экран Аккаунта
            composable<AccountRoute> {
               //Тут экран Мой профиль
            }


            composable<DetailRoute> { backStackEntry ->
               //Тут экран деталей курса
            }
        }
    }
}