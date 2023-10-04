package com.hopcape.wallpapers.presentation.screen.home.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hopcape.wallpapers.R
import com.hopcape.wallpapers.presentation.navigation.Screen
import com.hopcape.wallpapers.ui.theme.PurplishRed

/**
 * Wrapper around the bottom nav item
 * @param label to be shown
 * @param iconResId icon for the route
 * @param route actual route */
data class BottomNavItem(
    val label: Int,
    val iconResId: Int,
    val route: String
)

val bottomNavMenuItems = listOf(
    BottomNavItem(
        label = R.string.home,
        iconResId = R.drawable.home,
        route = Screen.HomeScreen.Home.route
    ),
    BottomNavItem(
        label = R.string.catalog,
        iconResId = R.drawable.catalog,
        route = Screen.HomeScreen.Catalog.route
    ),
    BottomNavItem(
        label = R.string.settings,
        iconResId = R.drawable.settings,
        route = Screen.HomeScreen.Settings.route
    ),
)

/**
 * Renders a list of Bottom Nav Option from
 * @param options onto the screen
 * @param navController -
 * @param modifier*/
@Composable
fun BottomNavigationMenu(
    modifier: Modifier = Modifier,
    options: List<BottomNavItem> = bottomNavMenuItems,
    navController: NavHostController = rememberNavController()
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = Color.Transparent
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination?.route

        Column(
            modifier = modifier,
        ) {
            Divider(
                color = PurplishRed
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                options.forEach { option ->
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                navController.navigate(
                                    route = option.route
                                ) {
                                    /**
                                     * Pop everything up to the start destination
                                     * and when the current destination is already the
                                     * start destination pop the graph*/
                                    navController.graph.startDestinationRoute?.let { route ->
                                        popUpTo(route){
                                            saveState = true
                                        }
                                    }
                                    /**
                                     * Avoiding multiple copies of the same route
                                     * when re selecting the route multiple times*/
                                    launchSingleTop = true

                                    /**
                                     * Restore the state when selecting the previously
                                     * selected item*/
                                    restoreState = true
                                }
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Icon
                        Icon(
                            painter = painterResource(id = option.iconResId),
                            contentDescription = "${option.label} Icon",
                            tint = if (currentDestination == option.route) PurplishRed else Color.LightGray
                        )
                        // Label
                        Text(
                            text = stringResource(id = option.label),
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = if (currentDestination == option.route) PurplishRed else Color.LightGray
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun BottomNavigationMenuPreview() {
    BottomNavigationMenu()
}




















