package com.hopcape.wallpapers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.hopcape.wallpapers.presentation.navigation.RootNavGraph
import com.hopcape.wallpapers.ui.theme.WallpapersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            WallpapersTheme {
                val navController = rememberNavController()
                RootNavGraph(
                    navController = navController
                )
            }
        }
    }
}
