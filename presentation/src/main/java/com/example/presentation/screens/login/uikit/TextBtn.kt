package com.example.presentation.screens.login.uikit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun TextBtn(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
){

    Text(
        text = text,
        modifier = modifier
            .clickable{
                onClick()
            },
        color = Color(0xFF12B956),
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold
    )
}