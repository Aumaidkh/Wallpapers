package com.hopcape.wallpapers.presentation.screen.home.composables

import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hopcape.wallpapers.R
import com.hopcape.wallpapers.ui.theme.PurplishRed

data class BottomNavItem(
    val label: Int,
    val iconResId: Int
)

val bottomNavMenuItems = listOf(
    BottomNavItem(
        label = R.string.home,
        iconResId = R.drawable.home
    ),
    BottomNavItem(
        label = R.string.catalog,
        iconResId = R.drawable.catalog
    ),
    BottomNavItem(
        label = R.string.settings,
        iconResId = R.drawable.settings
    ),
)

/**
 * Renders a list of Bottom Nav Option from
 * @param options onto the screen
 * @param selectedOption - option which is currently selected
 * @param onOptionClicked - invoked when and Option is Clicked*/
@Composable
fun BottomNavigationMenu(
    modifier: Modifier = Modifier,
    options: List<BottomNavItem> = bottomNavMenuItems,
    selectedOption: (BottomNavItem) = bottomNavMenuItems.first(),
    onOptionClicked: (BottomNavItem) -> Unit = {}
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = Color.Transparent
    ) {
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
                                onOptionClicked(option)
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Icon
                        Icon(
                            painter = painterResource(id = option.iconResId),
                            contentDescription = "${option.label} Icon",
                            tint = if (selectedOption == option) PurplishRed else Color.LightGray
                        )
                        // Label
                        Text(
                            text = stringResource(id = option.label),
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = if (selectedOption == option) PurplishRed else Color.LightGray
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




















