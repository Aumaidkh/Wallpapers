package com.hopcape.wallpapers.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hopcape.wallpapers.presentation.navigation.Graph
import com.hopcape.wallpapers.presentation.navigation.Screen

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
            HomeContent()
        }
        // Catalog Screen
        composable(
            route = Screen.HomeScreen.Catalog.route
        ){
            CatalogContent()
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