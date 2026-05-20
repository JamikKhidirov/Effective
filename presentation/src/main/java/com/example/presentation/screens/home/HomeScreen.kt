package com.example.presentation.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
@Preview(showBackground = true)
fun HomeScreen(){


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            //Тут будет верхний бар приложения
        }
    ) { innerPadding ->
        BottomHomeScreen(
            paddingValues = innerPadding
        )
    }
}


@Composable
fun BottomHomeScreen(
    paddingValues: PaddingValues
)
{

}