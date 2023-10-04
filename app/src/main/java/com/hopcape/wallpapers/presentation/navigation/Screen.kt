package com.hopcape.wallpapers.presentation.navigation

sealed class Screen(val route: String){
    object OnBoardingScreen: Screen("onboarding")

    // Home Screen Nested Navigation Graph
    object HomeScreen {
        // Home
        object Home:Screen("home")

        // Catalog
        object Catalog: Screen("catalog")

        // Settings
        object Settings: Screen("settings")
    }
}
