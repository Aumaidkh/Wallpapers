package com.hopcape.wallpapers.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hopcape.wallpapers.domain.model.WallpaperModel
import com.hopcape.wallpapers.presentation.screen.home.composables.OutlinedCircularButton
import com.hopcape.wallpapers.presentation.screen.home.composables.TopBar

/**
 * Renders
 * @param images - list of image url
 * @param modifier
 * @param paddingValues
 * @param pagerState*/

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    images: List<WallpaperModel> = emptyList(),
    pagerState: PagerState = PagerState(),
    onMoreClicked: (WallpaperModel) -> Unit = {}
) {
    val context = LocalContext.current
    VerticalPager(
        modifier = modifier,
        pageCount = images.size,
        state = pagerState
    ) {
        val wallpaper = images[it]
        // Display Full Screen Image Here
        val imageRequest = ImageRequest
            .Builder(context)
            .crossfade(true)
            .data(wallpaper.imageUrl)
            .build()
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            // Image
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = imageRequest,
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(
                    color = Color.Black.copy(alpha = 0.6f),
                    blendMode = BlendMode.Multiply
                )
            )

            // Top bar
            TopBar(
                title = wallpaper.name,
                onMoreClick = {
                    onMoreClicked(wallpaper)
                }
            )

            // Download Button Here
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                OutlinedCircularButton(
                    modifier = Modifier
                        .padding(
                            bottom = paddingValues.calculateBottomPadding(),
                            end = paddingValues.calculateEndPadding(LayoutDirection.Ltr)
                        )
                        .padding(
                            vertical = 32.dp,
                            horizontal = 24.dp
                        ),
                    internalPadding = 16.dp
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HomeContentPreview() {
    HomeContent()
}