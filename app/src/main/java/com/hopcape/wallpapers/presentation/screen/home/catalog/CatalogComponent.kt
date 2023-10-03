package com.hopcape.wallpapers.presentation.screen.home.catalog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hopcape.wallpapers.domain.model.WallpaperModel
import com.hopcape.wallpapers.ui.theme.PurplishRed
import java.util.Locale

/**
 * Shows a catalog with
 * @param name - catalog name
 * @param wallpapers - list of wallpapers from the catalog
 * onto the screen in a horizontal layout*/
@Composable
fun CatalogComponent(
    modifier: Modifier = Modifier,
    name: String = "Nature",
    wallpapers: List<WallpaperModel> = emptyList()
) {
    Column(
        modifier = modifier
    ) {
        // Catalog Name and See More
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 19.sp
                )
            )
            SeeAll()
        }

        // Actual Wallpaper Thumbnails
        LazyRow{
            items(wallpapers){
                CatalogThumbnail(
                   imageUrl = it.imageUrl,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(180.dp)
                        .width(130.dp)
                        .border(
                            border = BorderStroke(
                                width = 1.dp,
                                color = PurplishRed
                            ),
                            shape = RoundedCornerShape(
                                8.dp
                            )
                        )
                        .padding(2.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun CatalogComponentPreview() {
    CatalogComponent()
}

@Composable
fun SeeAll(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "See All",
            style = TextStyle(
                color = PurplishRed,
                fontSize = 14.sp
            )
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "See All",
            tint = PurplishRed
        )
    }
}

@Preview
@Composable
fun SeeAllPreview() {
    SeeAll()
}