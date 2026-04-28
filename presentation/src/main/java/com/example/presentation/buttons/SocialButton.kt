package com.example.presentation.buttons

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.buttons.state.SocialButtonState


@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    buttonState: SocialButtonState = SocialButtonState.VK,
    onClickButton: () -> Unit = {}
){
    val state by remember(buttonState){
        mutableStateOf(buttonState)
    }

    when (state) {
        SocialButtonState.VK -> {

        }
        SocialButtonState.ODNOKLASSNIKS -> {

        }
    }
}


@Composable
@Preview(showBackground = true)
fun SocBtn(
    modifier: Modifier = Modifier,
    socialButtonState: SocialButtonState = SocialButtonState.VK,
    onClick: () -> Unit = {}
){
    val state by remember(socialButtonState) {
        mutableStateOf(socialButtonState)
    }

    Button(
        modifier = modifier.width(156.dp)
            .height(40.dp),
        onClick = onClick,
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (state == SocialButtonState.VK) Color(0xFF2683ED) else Color(0xFFF98509)
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = if (state == SocialButtonState.VK) painterResource(R.drawable.vk) else painterResource(R.drawable.odnoklass),
                contentDescription = null
            )
        }
    }
}