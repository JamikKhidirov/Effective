package com.example.presentation.screens.login.uikit.text


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit




@Composable
fun TextLogIn(
    text: String = "Вход",
    modifier: Modifier,
    color: Color = Color.White,
    textSize: TextUnit
){

    Text(
        text = text,
        fontSize = textSize,
        color = color,
        modifier = modifier
    )
}