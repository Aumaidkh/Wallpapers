package com.hopcape.wallpapers.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hopcape.wallpapers.presentation.screen.home.HomeScreen
import com.hopcape.wallpapers.presentation.screen.home.HomeScreenViewModel
import com.hopcape.wallpapers.presentation.screen.onboarding.OnBoardingScreen

@Composable
fun WallpapersNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.OnBoardingScreen.route
    ){
        // Define OnBoarding Route Here
        composable(
            route = Screen.OnBoardingScreen.route
        ){
            OnBoardingScreen(
                onNavigateToHome = {
                    navController.navigate(
                        route = Screen.HomeScreen.route
                    ){
                        popUpTo(route = Screen.OnBoardingScreen.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
        // Define Home Route Here
        composable(
            route = Screen.HomeScreen.route
        ){
            val viewModel: HomeScreenViewModel = hiltViewModel()
            val state = viewModel.state.collectAsState()
            HomeScreen(
                state = state.value
            )
        }
    }
}