package com.hopcape.wallpapers.presentation.screen.home.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hopcape.wallpapers.ui.theme.Jaguar

/**
 * @param onOptionClicked - invoked when an option from the setting screen is
 * clicked
 * @param paddingValues*/
@Composable
fun SettingsContent(
    paddingValues: PaddingValues = PaddingValues(),
    onOptionClicked: (SettingsOption) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(
                color = Jaguar
            )
            .fillMaxSize()
            .padding(
                bottom = paddingValues.calculateBottomPadding(),
                top = paddingValues.calculateTopPadding()
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Bar
        Text(
            text = "Settings",
            color = Color.White,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 23.sp
            )
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            options.forEach {
                SettingsOption(
                    modifier = Modifier
                        .padding(
                            vertical = 4.dp
                        )
                        .clickable {
                             onOptionClicked(it)
                        },
                    option = it
                )
            }
        }
    }
}

@Preview
@Composable
fun SettingsContentPreview() {
    SettingsContent()
}