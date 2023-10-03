package com.hopcape.wallpapers.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hopcape.wallpapers.presentation.screen.home.composables.BottomNavigationMenu
import com.hopcape.wallpapers.presentation.screen.home.composables.OutlinedCircularButton
import com.hopcape.wallpapers.presentation.screen.home.composables.TopBar
import com.hopcape.wallpapers.presentation.screen.home.composables.bottomNavMenuItems

private const val TAG = "HomeScreen"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    onNavigateToOnBoarding: () -> Unit = {}
) {

    var paddingValues = remember {
        PaddingValues()
    }

    Scaffold(
        bottomBar = {
            BottomNavigationMenu(
                navController = navController
            )
        }
    ) {
        HomeNavGraph(
            navController = navController,
            paddingValues = it,
            onNavigateToOnBoarding = onNavigateToOnBoarding
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

