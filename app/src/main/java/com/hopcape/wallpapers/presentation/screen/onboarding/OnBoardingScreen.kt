package com.hopcape.wallpapers.presentation.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hopcape.wallpapers.presentation.screen.onboarding.composables.OnBoardingBottomSheet
import com.hopcape.wallpapers.presentation.screen.onboarding.composables.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    onNavigateToHome: () -> Unit = {}
) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    HorizontalPager(
        pageCount = 3,
        state = pagerState
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = 24.dp
                ),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = onBoardingPages[page].backgroundResId),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PageIndicator(
                    selectedPosition = page,
                    count = onBoardingPages.size
                )
                Spacer(modifier = Modifier.height(32.dp))
                OnBoardingBottomSheet(
                    title = stringResource(id = onBoardingPages[page].heading),
                    body = stringResource(id = onBoardingPages[page].desc),
                    onContinue = {
                        scope.launch {
                            if (!pagerState.canScrollForward){
                                onNavigateToHome()
                            } else {
                                pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                            }
                        }
                    }
                )
            }
        }
    }

}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen()
}