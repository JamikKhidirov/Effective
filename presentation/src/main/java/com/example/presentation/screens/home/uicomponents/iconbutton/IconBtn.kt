package com.example.presentation.screens.home.uicomponents.iconbutton

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R


@Composable
@Preview
fun IconBtn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){
  IconButton(
      onClick = onClick,
      modifier = modifier,
      colors = IconButtonDefaults.iconButtonColors(
          containerColor =  Color(0xFF24252A).copy(0.8f)
      )
  ) {
      Icon(
          painter = painterResource(R.drawable.filter),
          contentDescription = null,
          tint = Color.White,
      )
  }
}
