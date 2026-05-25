package com.example.presentation.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.domain.data.Course
import com.example.presentation.screens.home.uicomponents.FilterTextButton
import com.example.presentation.screens.home.uicomponents.bottombar.BottomBar
import com.example.presentation.screens.home.uicomponents.iconbutton.IconBtn
import com.example.presentation.screens.home.uicomponents.topbar.TopBar
import com.example.presentation.screens.home.vidjets.CourseCard
import com.example.presentation.screens.home.viewmodel.HomeViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navHostController: NavHostController,
    onDetailClick: (course: Course) -> Unit = {}
) {
    // Подписываемся на состояние экрана
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val isSortActive = (uiState as? HomeUiState.Success)?.isSortActive ?: false

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black,
        topBar = {
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.statusBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .height(IntrinsicSize.Max)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TopBar(modifier = Modifier.weight(1f)) { }

                    IconBtn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                            .padding(start = 8.dp)
                    ) { }
                }

                FilterTextButton(
                    modifier = Modifier,
                    isActive = isSortActive
                ) {
                    viewModel.toggleDateSorting()
                }
            }
        },
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

        // Распределяем контент в зависимости от стейта
        when (val state = uiState) {
            is HomeUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color(0xFF00B0FF))
                }
            }

            is HomeUiState.Success -> {
                BottomHomeScreen(
                    paddingValues = innerPadding,
                    coursesList = state.courses,
                    savedCourseIds = state.savedIds, // Передаем сет ID из Room
                    onSaveToggle = { course, isSaved ->
                        // Вызываем метод ViewModel для добавления/удаления
                        viewModel.toggleBookmark(course, isSaved)
                    },
                    onDetailCourse = onDetailClick
                )
            }

            is HomeUiState.Error -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = state.message, color = Color.White)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { viewModel.loadCourses() }) {
                        Text("Повторить")
                    }
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomHomeScreen(
    paddingValues: PaddingValues,
    coursesList: List<Course>,
    savedCourseIds: Set<Int>,
    onSaveToggle: (Course, Boolean) -> Unit,
    onDetailCourse: (course: Course) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(
            items = coursesList,
            key = { course -> course.id }
        ) { course ->
            val isSaved = savedCourseIds.contains(course.id)

            Box(
                modifier = Modifier.animateItem()
            ) {
                CourseCard(
                    course = course,
                    isSaved = isSaved,
                    onDetailClick = { onDetailCourse(course) },
                    onSaveCourse = { clickedCourse ->
                        onSaveToggle(clickedCourse, isSaved)
                    }
                )
            }
        }
    }
}