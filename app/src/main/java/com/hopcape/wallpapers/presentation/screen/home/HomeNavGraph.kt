package com.hopcape.wallpapers.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hopcape.wallpapers.presentation.composables.LoadingScreen
import com.hopcape.wallpapers.presentation.navigation.Graph
import com.hopcape.wallpapers.presentation.navigation.Screen
import com.hopcape.wallpapers.presentation.screen.home.catalog.CatalogContent
import com.hopcape.wallpapers.presentation.screen.home.catalog.CatalogViewModel

/**
 * Contains the nav graph of the home screen
 * Following routes will be added
 * 1. Home
 * 2. Catalog
 * 3. Settings*/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeNavGraph(
    navController: NavHostController = rememberNavController(),
    paddingValues: PaddingValues = PaddingValues(),
) {
    NavHost(
        navController = navController,
        route = Graph.HomeGraph,
        startDestination = Screen.HomeScreen.Home.route
    ){
        // Home Screen
        composable(
            route = Screen.HomeScreen.Home.route
        ){
            val viewModel: HomeScreenViewModel = hiltViewModel()
            val state = viewModel.state.collectAsState()

            if (state.value.loading){
                LoadingScreen()
            } else {
                HomeContent(
                    images = state.value.wallpapers,
                    pagerState = rememberPagerState()
                )
            }
        }
        // Catalog Screen
        composable(
            route = Screen.HomeScreen.Catalog.route
        ){
            val viewModel: CatalogViewModel = hiltViewModel()
            val state = viewModel.state.collectAsState()

            if (state.value.loading){
                LoadingScreen()
            } else {
                CatalogContent()
            }
        }
        // Settings Screen
        composable(
            route = Screen.HomeScreen.Settings.route
        ){
            Box(modifier = Modifier.fillMaxSize()){
                Text(text = "Settings")
            }
        }
    }
}