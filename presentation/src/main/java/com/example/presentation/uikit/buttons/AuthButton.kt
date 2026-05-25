package com.example.presentation.uikit.buttons


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview(showBackground = true)
fun AuthButton(
    modifier: Modifier = Modifier,
    text: String = "Вход",
    isActive: Boolean = true,
    onClick: () -> Unit = {}
){
    Button(
        modifier = modifier,
        enabled = isActive,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF12B956),
            contentColor = Color.White,                 // Цвет текста активной кнопки
            disabledContainerColor = Color(0xFF2C2C2C), // Фоновый цвет НЕАКТИВНОЙ кнопки (серый, чтобы было видно на черном)
            disabledContentColor = Color(0xFF7A7A7A)    // Цвет текста НЕАКТИВНОЙ кнопки
        ),
        shape = RoundedCornerShape(30.dp),
        onClick = onClick,

    ) {
        Text(
            text = text,
            modifier = Modifier,
            fontWeight = FontWeight(500)
        )
    }
}