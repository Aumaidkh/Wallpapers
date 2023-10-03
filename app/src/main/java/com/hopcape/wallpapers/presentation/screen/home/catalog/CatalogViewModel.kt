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
    private val catalogRepository: ICatalogRepository
): ViewModel(){

    /**
     * Screen State*/
    private val _state = MutableStateFlow(CatalogScreenState())
    val state get() = _state.asStateFlow()

    init {
        loadCatalogs()
    }
    private fun loadCatalogs(){
        viewModelScope.launch {
            try {
                catalogRepository.getCatalogs().also { catalogs ->
                    catalogs?.let {
                        _state.update {
                            it.copy(
                                loading = false,
                                catalogs = catalogs
                            )
                        }
                    }?: _state.update {
                        it.copy(
                            loading = false
                        )
                    }
                }
            }catch (e: Exception){
                e.printStackTrace()
                _state.update {
                    it.copy(
                        loading = false
                    )
                }
            }
        }
    }

}