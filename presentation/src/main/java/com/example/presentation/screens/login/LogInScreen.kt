package com.example.presentation.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.contextmenu.modifier.appendTextContextMenuComponents
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.screens.login.uikit.TextBtn
import com.example.presentation.screens.login.uikit.text.TextLogIn
import com.example.presentation.screens.login.uikit.textfilds.AuthTextFild
import com.example.presentation.uikit.buttons.AuthButton
import com.example.presentation.uikit.buttons.SocialButton
import com.example.presentation.uikit.buttons.state.SocialButtonState


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

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                TextLogIn(
                    modifier = Modifier,
                    text = "Нету аккаунта?",
                    textSize = 12.sp
                )

                TextBtn(
                    text = "Регистрация",
                    modifier = Modifier
                        .padding(start = 5.dp)
                ) {
                    //Заглушка
                }
            }

            TextBtn(
                text = "Забыл пороль",
                modifier = Modifier
                    .padding(
                        top = 8.dp
                    )
            ) {
                //Заглушка
            }
        }

        Divider(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                )
                .padding(
                    top = 32.dp
                ),
            color = Color(0xFF4D555E)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            SocialButton(
                modifier = Modifier,
                buttonState = SocialButtonState.VK
            ) {
                //Переходим по ссылке в бразере https://vk.com/
            }

            SocialButton(
                modifier = Modifier
                    .padding(start = 16.dp),
                buttonState = SocialButtonState.ODNOKLASSNIKS
            ) {
                //Переходим по ссылке в браузере https://ok.ru/
            }
        }
    }
}

