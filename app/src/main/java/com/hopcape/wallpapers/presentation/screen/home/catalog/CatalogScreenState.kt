package com.hopcape.wallpapers.presentation.screen.home.catalog

import com.hopcape.wallpapers.domain.model.CatalogModel

/**
 * @param loading - loading state
 * @param catalogs - actual list of catalogs*/
data class CatalogScreenState(
    val loading: Boolean = false,
    val catalogs: List<CatalogModel> = emptyList()
)
