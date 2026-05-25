package com.example.presentation.screens.saved

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.domain.data.Course
import com.example.presentation.screens.home.uicomponents.bottombar.BottomBar
import com.example.presentation.screens.home.vidjets.CourseCard
import com.example.presentation.screens.saved.viewmodel.SavedCoursesViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SavedCoursesScreen(
    navHostController: NavHostController,
    onDetailClick: (course: Course) -> Unit,
    viewModel: SavedCoursesViewModel = hiltViewModel()
) {
    val savedCourses by viewModel.savedCourses.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF121214),
        bottomBar = {
            Column {
                HorizontalDivider(color = Color.Gray)
                BottomBar(
                    modifier = Modifier,
                    navController = navHostController,
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding())
        ) {

            Text(
                text = "Избранное",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 12.dp)
            )

            if (savedCourses.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Здесь будут ваши сохраненные курсы",
                        color = Color(0xFF727477),
                        fontSize = 16.sp
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(
                        items = savedCourses,
                        key = { it.id }
                    ) { course ->
                        CourseCard(
                            course = course,
                            isSaved = true,
                            onDetailClick = { onDetailClick(course) },
                            onSaveCourse = { viewModel.removeFromBookmark(course) }
                        )
                    }
                }
            }
        }
    }
}