package com.hopcape.wallpapers.presentation.screen.home.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hopcape.wallpapers.domain.repo.ICatalogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val repo: ICatalogRepository
): ViewModel(){

    private val _state = MutableStateFlow(CatalogScreenState())
    val state get() = _state.asStateFlow()

    init {
        loadCatalogs()
    }

    private fun loadCatalogs(){
        viewModelScope.launch {
            try {
                repo.getCatalogs().also { catalogs ->
                    _state.update {
                        it.copy(
                            catalogs = catalogs?.map { catalogModel ->
                                CatalogItem(
                                name = catalogModel.name,
                                items = catalogModel.wallpapers
                            ) } ?: emptyList()
                        )
                    }
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}