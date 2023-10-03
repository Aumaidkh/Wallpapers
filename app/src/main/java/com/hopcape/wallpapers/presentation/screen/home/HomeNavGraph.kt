package com.hopcape.wallpapers.presentation.screen.home

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hopcape.wallpapers.presentation.composables.LoadingScreen
import com.hopcape.wallpapers.presentation.getAppUrl
import com.hopcape.wallpapers.presentation.navigation.Graph
import com.hopcape.wallpapers.presentation.navigation.Screen
import com.hopcape.wallpapers.presentation.screen.home.catalog.CatalogContent
import com.hopcape.wallpapers.presentation.screen.home.catalog.CatalogViewModel
import com.hopcape.wallpapers.presentation.screen.home.settings.OptionType
import com.hopcape.wallpapers.presentation.screen.home.settings.SettingsContent
import kotlinx.coroutines.launch

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
    onNavigateToOnBoarding: () -> Unit = {}
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
                    paddingValues = paddingValues,
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
                CatalogContent(
                    paddingValues = paddingValues,
                    catalogs = state.value.catalogs
                )
            }
        }
        // Settings Screen
        composable(
            route = Screen.HomeScreen.Settings.route
        ) {
            val context = LocalContext.current
            SettingsContent(
                paddingValues = paddingValues,
                onOptionClicked = { settingOption ->
                    when(settingOption.type){
                        OptionType.TUTORIAL -> {
                            // User has clicked on Tutorial
                            // Show user the onboarding flow again
                            onNavigateToOnBoarding()
                        }
                        OptionType.RATE_US -> {
                            // User has clicked on Rate Us
                            // Send user to play store where he can rate the app
                            val intent = Intent().apply {
                                action = Intent.ACTION_VIEW
                                data = Uri.parse(getAppUrl(context))
                            }
                            try {
                                context.startActivity(intent)
                            }catch (e: Exception){
                                e.printStackTrace()
                            }
                        }
                        OptionType.SHARE -> {
                            // User has clicked on Share App
                            val shareIntent = Intent().apply {
                                action = Intent.ACTION_SEND
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT,"Check out this awesome wallpapers app: ${getAppUrl(context)}")
                            }

                            val intentChooser = Intent.createChooser(shareIntent,"Share Via")
                            context.startActivity(intentChooser)
                        }
                    }
                }
            )
        }
    }
}