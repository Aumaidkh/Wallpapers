package com.hopcape.wallpapers.domain.model

/**
 * Catalog Model
 * @param name - name for the catalog
 * @param wallpapers - wallpapers belonging to this catalog*/
data class CatalogModel(
    val name: String,
    val wallpapers: List<WallpaperModel>
)
