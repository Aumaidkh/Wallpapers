package com.hopcape.wallpapers.domain.repo

import com.hopcape.wallpapers.domain.model.CatalogModel


/**
 * Repository for fetching or manipulating
 * the catalogs*/
interface ICatalogRepository {

    /**
     * Fetches the list of catalogs from the datasource*/
    suspend fun getCatalogs(): List<CatalogModel>?

}