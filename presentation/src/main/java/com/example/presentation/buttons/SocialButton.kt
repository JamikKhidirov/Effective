package com.example.presentation.buttons

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
        modifier = modifier,
        onClick = onClick
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