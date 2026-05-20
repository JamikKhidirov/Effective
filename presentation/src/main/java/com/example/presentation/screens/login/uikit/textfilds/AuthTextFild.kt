package com.example.presentation.screens.login.uikit.textfilds

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


@Composable
@Preview(showBackground = true)
fun AuhTextFild(
    value:  String = "",
    onTextChange: (String) -> Unit = {}
){

    val text by remember(value) { mutableStateOf(value) }

    TextField(
        value = text,
        onValueChange = onTextChange,

    )



}