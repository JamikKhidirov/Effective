package com.example.presentation.screens.login

import android.content.Intent
import android.net.Uri
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.presentation.navigation.HomeRoute
import com.example.presentation.screens.login.uikit.TextBtn
import com.example.presentation.screens.login.uikit.text.TextLogIn
import com.example.presentation.screens.login.uikit.textfilds.AuthTextFild
import com.example.presentation.uikit.buttons.AuthButton
import com.example.presentation.uikit.buttons.SocialButton
import com.example.presentation.uikit.buttons.state.SocialButtonState


@Composable
fun LogInScreen(
    navHostController: NavHostController
){


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {innerPadding ->
        BottomLogInscreen(
            navHostController = navHostController,
            onEmailChange = {email ->

            },
            onPasswordChange = {password ->

            }
        )
    }
}



@Composable
fun BottomLogInscreen(
    navHostController: NavHostController,
    onEmailChange: (email: String) -> Unit,
    onPasswordChange: (password: String) -> Unit
){
    val context = LocalContext.current


    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }

    val isEmailValid = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPasswordValid = password.isNotEmpty()

    val cyrillicRegex = Regex("[а-яА-ЯёЁ]")

    val isLoginButtonEnabled = isEmailValid && isPasswordValid

    Column(
        modifier = Modifier
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
                if (!newEmail.contains(cyrillicRegex)) {
                    email = newEmail
                    onEmailChange(newEmail)
                }

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
            isActive = isLoginButtonEnabled,
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
                .padding(
                    top = 24.dp
                ),
            onClick = {
                //Тут будем обрабатывать клик
                navHostController.navigate(HomeRoute){
                    popUpTo(HomeRoute){
                        inclusive = true
                    }
                }
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
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/"))
                context.startActivity(intent)

            }

            SocialButton(
                modifier = Modifier
                    .padding(start = 16.dp),
                buttonState = SocialButtonState.ODNOKLASSNIKS
            ) {
                //Переходим по ссылке в браузере https://ok.ru/
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ok.ru/"))
                context.startActivity(intent)
            }
        }
    }
}

