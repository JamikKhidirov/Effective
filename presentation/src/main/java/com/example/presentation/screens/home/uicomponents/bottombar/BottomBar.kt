package com.example.presentation.screens.home.uicomponents.bottombar

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.presentation.R
import com.example.presentation.navigation.AccountRoute
import com.example.presentation.navigation.HomeRoute
import com.example.presentation.navigation.SavedRoute


@SuppressLint("RestrictedApi")
@Composable
fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Список вкладок со строгими типами роутов
    val items = remember {
        listOf(
            BottomBarData(
                text = "Главная",
                icon = R.drawable.house,
                route = HomeRoute
            ),

            BottomBarData(
                text = "Избранное",
                icon = R.drawable.bookmark,
                route = SavedRoute
            ),

            BottomBarData(
                text = "Аккаунт",
                icon = R.drawable.person,
                route = AccountRoute
            )
        )
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val darkalpha = remember { Color.LightGray.copy(0.07f) }

    NavigationBar(
        modifier = modifier,
        containerColor = Color(0xFF4D555E).copy(0.2f)
    ) {
        items.forEach { data ->
            // БЕЗОПАСНАЯ ПРОВЕРКА: проверяем, открыт ли класс этого роута прямо сейчас
            val isSelected = currentDestination?.hasRoute(data.route::class) == true

            NavigationBarItem(
                selected = isSelected,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = if (isSelected) darkalpha else Color.Transparent
                ),
                onClick = {
                    if (!isSelected) {
                        navController.navigate(data.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(data.icon),
                        contentDescription = null,
                        tint = if (isSelected) Color(0XFF12B956) else Color.White
                    )
                },
                label = {
                    Text(
                        text = data.text,
                        color = if (isSelected) Color(0XFF12B956) else Color.White,
                        fontSize = 12.sp
                    )
                }
            )
        }
    }
}