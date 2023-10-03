package com.hopcape.wallpapers.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.hopcape.wallpapers.presentation.screen.home.composables.BottomNavigationMenu
import com.hopcape.wallpapers.presentation.screen.home.composables.OutlinedCircularButton
import com.hopcape.wallpapers.presentation.screen.home.composables.TopBar
import com.hopcape.wallpapers.presentation.screen.home.composables.bottomNavMenuItems

private const val TAG = "HomeScreen"
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    state: HomeScreenState = HomeScreenState()
) {
    var selectedOption by remember {
        mutableStateOf(bottomNavMenuItems.first())
    }
    var paddingValues = remember {
        PaddingValues()
    }
    val pagerState = rememberPagerState()

    var title by remember {
        mutableStateOf("")
    }

    Scaffold(
        bottomBar = {
            BottomNavigationMenu(
                selectedOption = selectedOption,
                onOptionClicked = {
                    selectedOption = it
                }
            )
        },
        floatingActionButton = {
            OutlinedCircularButton(
                modifier = Modifier.padding(
                    bottom = paddingValues.calculateBottomPadding(),
                    end = paddingValues.calculateEndPadding(LayoutDirection.Ltr)
                ),
                internalPadding = 16.dp
            )
        }
    ) {
        paddingValues = it
        // When Loading Show Circular Loader
        if (state.loading){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        } else {
            HomeContent(
                pagerState = pagerState,
                images = state.wallpapers,
                onMoreClicked = {}
            )
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

