package com.hopcape.wallpapers.presentation.screen.home.catalog

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

/**
 * Shows a rounded image loaded from
 * @param imageUrl
 * @param cornerRadius*/
@Composable
fun CatalogThumbnail(
    modifier: Modifier = Modifier,
    imageUrl: String = "",
    cornerRadius: Dp = 8.dp
) {
    val imageRequest = ImageRequest
        .Builder(LocalContext.current)
        .data(imageUrl)
        .build()

    AsyncImage(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(cornerRadius)
            ),
        model = imageRequest,
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun CatalogThumbnailPreview() {
    CatalogThumbnail()
}