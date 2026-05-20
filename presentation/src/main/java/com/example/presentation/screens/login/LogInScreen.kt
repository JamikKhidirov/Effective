package com.example.presentation.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.contextmenu.modifier.appendTextContextMenuComponents
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.screens.login.uikit.text.TextLogIn
import com.example.presentation.screens.login.uikit.textfilds.AuthTextFild
import com.example.presentation.uikit.buttons.AuthButton


@Composable
@Preview(showBackground = true)
fun LogInScreen(){


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {innerPadding ->
        BottomLogInscreen(
            paddingValues = innerPadding,
            onEmailChange = {email ->

            },
            onPasswordChange = {password ->

            }
        )
    }
}



@Composable
fun BottomLogInscreen(
    paddingValues: PaddingValues,
    onEmailChange: (email: String) -> Unit,
    onPasswordChange: (password: String) -> Unit
){

    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(
                paddingValues = paddingValues
            )
            .fillMaxSize()
            .background(Color.Black)
    ) {

        TextLogIn(
            text = "Вход",
            textSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 100.dp
                )
                .padding(
                    horizontal = 16.dp,
                    )
        )

        TextLogIn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 28.dp,
                )
                .padding(
                    horizontal = 16.dp
                ),
            textSize = 16.sp,
            text = "Email"
        )

        AuthTextFild(
            value = email,
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
                .padding(
                    top = 8.dp
                ),
            onTextChange = { newEmail ->
                email = newEmail
                onEmailChange(newEmail)
            }
        )

        TextLogIn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                )
                .padding(
                    horizontal = 16.dp
                ),
            textSize = 16.sp,
            text = "Пароль"
        )

        AuthTextFild(
            placeHoldedrText = "Введите пароль",
            value = password,
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
                .padding(
                    top = 8.dp
                ),
            onTextChange = { newPass ->
                password = newPass
                onPasswordChange(newPass)
            }
        )

        AuthButton(
            text = "Вход",
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
                .padding(
                    top = 24.dp
                ),
            onClick = {
                //Тут будем обрабатывать клик
            }
        )
    }
}

