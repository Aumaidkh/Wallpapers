package com.hopcape.wallpapers.domain.repo

import com.hopcape.wallpapers.domain.model.WallpaperModel

interface IWallpapersRepository {

    /**
     * Returns a list of wallpapers from the datasource
     * */
    suspend fun getWallpapers(): List<WallpaperModel>?

    /**
     * Returns a list of wallpapers for the
     * @param category*/
    suspend fun getWallpapersFor(category: String): List<WallpaperModel>?

}