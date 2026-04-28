package com.example.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
@Preview(showBackground = true)
fun LogInScreen(){


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {innerPadding ->
        BottomLogInscreen(
            paddingValues = innerPadding
        )
    }
}



@Composable
fun BottomLogInscreen(
    paddingValues: PaddingValues
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                paddingValues = paddingValues
            )
    ) {

    }
}

