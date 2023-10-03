package com.hopcape.wallpapers.presentation.screen.home.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hopcape.wallpapers.ui.theme.Jaguar

/**
 * Screen showing different categories of wallpapers
 * @param state - screen state which is catalog screen state over here*/
@Composable
fun CatalogContent(
    paddingValues: PaddingValues = PaddingValues(),
    catalogs: List<CatalogItem> = emptyList()
) {
    // Showing Catalogs
    LazyColumn(
        modifier = Modifier
            .background(color = Jaguar)
            .padding(
                bottom = paddingValues.calculateBottomPadding(),
                top = paddingValues.calculateTopPadding()
            )
    ){
        items(catalogs){
            CatalogComponent(
                modifier = Modifier.padding(
                    vertical = 4.dp
                ),
                name = it.name,
                wallpapers = it.items
            )
        }
    }

}

@Preview
@Composable
fun CatalogContentPreview() {
    CatalogContent()
}