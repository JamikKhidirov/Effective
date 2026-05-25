package com.example.presentation.screens.home.uicomponents.topbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R


@Composable
@Preview(showBackground = true)
fun TopBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){

    Card(
        modifier = modifier,
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF24252A).copy(0.8f)
        ),
        shape = RoundedCornerShape(28.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = null,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                tint = Color.White
            )

            Text(
                text = "Search courses...",
                color = Color(0xFFF2F2F3).copy(0.6f),
                modifier = Modifier.padding(
                    vertical = 8.dp
                )
            )

        }
    }
}