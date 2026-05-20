package com.example.presentation.screens.login.uikit.textfilds

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview(showBackground = true)
fun AuthTextFild(
    value:  String = "",
    modifier: Modifier = Modifier,
    placeHoldedrText: String = "example@gmail.com",
    onTextChange: (String) -> Unit = {},

){

    val text by remember(value) { mutableStateOf(value) }

    TextField(
        value = text,
        modifier = modifier,
        onValueChange = onTextChange,
        shape = RoundedCornerShape(30.dp),
        colors =  TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFF32333A),
            focusedContainerColor = Color(0xFF32333A),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        ),
        singleLine = true,
        placeholder = {
            Text(
                text = placeHoldedrText,
                color = Color(0xFFF2F2F3)
                    .copy(0.5f),
                modifier = Modifier.padding(start = 16.dp)
            )
        }

    )



}