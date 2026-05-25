package com.example.presentation.screens.home.uicomponents

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.presentation.R


@Composable
fun FilterTextButton(
    modifier: Modifier = Modifier,
    isActive: Boolean, // Используем этот флаг!
    text: String = "По дате добавления",
    icon: Int? = R.drawable.strel,
    onClick: () -> Unit = {}
) {
    // Динамический цвет: зеленый, если активен, или серый, если выключен
    val contentColor by animateColorAsState(
        targetValue = if (isActive) Color(0xFF12B956) else Color(0xFF7A7A7A),
        label = "ColorAnimation"
    )

    // Плавный разворот стрелочки на 180 градусов при активации
    val rotationAngle by animateFloatAsState(
        targetValue = if (isActive) 180f else 0f,
        label = "RotationAnimation"
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onClick() }
            .padding(vertical = 8.dp) // Увеличим область клика
    ) {
        Text(
            modifier = modifier,
            text = text,
            color = contentColor, // Применяем анимированный цвет
            fontWeight = FontWeight(500)
        )
        icon?.let { iconRes ->
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                tint = contentColor, // Применяем анимированный цвет к иконке
                modifier = Modifier
                    .padding(start = 6.dp, end = 16.dp)
                    .rotate(rotationAngle) // Вращаем стрелку
            )
        }
    }
}