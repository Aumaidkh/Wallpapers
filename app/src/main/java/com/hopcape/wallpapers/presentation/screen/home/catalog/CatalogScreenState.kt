package com.hopcape.wallpapers.presentation.screen.home.catalog

import com.hopcape.wallpapers.domain.model.WallpaperModel

/**
 * Screen State for the Catalog Screen
 * @param loading
 * @param catalogs */
data class CatalogScreenState(
    val loading: Boolean = false,
    val catalogs: List<CatalogItem> = emptyList()
)

/**
 * Individual catalog item
 * @param name - category name
 * @param items - list of wallpapers*/
data class CatalogItem(
    val name: String,
    val items: List<WallpaperModel>
)
