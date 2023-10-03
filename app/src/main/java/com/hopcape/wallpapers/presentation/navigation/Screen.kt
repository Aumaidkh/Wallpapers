package com.hopcape.wallpapers.presentation.navigation

sealed class Screen(
    val route: String
){
    object OnBoardingScreen: Screen("onboarding")
    object HomeScreen: Screen("home")
}
