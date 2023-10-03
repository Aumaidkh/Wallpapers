package com.hopcape.wallpapers.presentation.screen.home

import com.hopcape.wallpapers.domain.model.WallpaperModel

data class HomeScreenState(
    val loading: Boolean = false,
    val wallpapers: List<WallpaperModel> = emptyList()
)
