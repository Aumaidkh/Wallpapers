package com.hopcape.wallpapers.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hopcape.wallpapers.presentation.screen.home.HomeScreen
import com.hopcape.wallpapers.presentation.screen.onboarding.OnBoardingScreen

/**
 * Root navigation graph of the app
 * Contains below nav graphs
 * 1. Onboarding Graph
 * 2. Home Graph*/
@Composable
fun RootNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.OnBoardingScreen.route
    ){
        // OnBoarding Screen
        composable(
            route = Screen.OnBoardingScreen.route
        ){
            OnBoardingScreen(
                onNavigateToHome = {
                    navController.popBackStack()
                    navController.navigate(
                        route = Graph.HomeGraph
                    )
                }
            )
        }
        // Home Graph
        composable(
            route = Graph.HomeGraph
        ){
            HomeScreen(
                onNavigateToOnBoarding = {
                    navController.navigate(
                        route = Screen.OnBoardingScreen.route
                    )
                }
            )
        }
    }
}