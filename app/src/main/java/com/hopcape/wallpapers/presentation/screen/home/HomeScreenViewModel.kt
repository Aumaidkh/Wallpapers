package com.hopcape.wallpapers.presentation.screen.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hopcape.wallpapers.domain.repo.IWallpapersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * StateHolder for the home screen
 * also exposes necessary apis for fetching wallpapers
 * @param repo - For Making use of api's*/
@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: IWallpapersRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    // Screen State
    private val _state = MutableStateFlow(HomeScreenState())
    val state get() = _state.asStateFlow()

    init {
        getAllWallpapers()
    }

    private fun getAllWallpapers(){
        viewModelScope.launch {
            showLoading()
            try {
                repository.getWallpapers().also { result ->
                    result?.let {
                        _state.update {
                            it.copy(
                                loading = false,
                                wallpapers = result
                            )
                        }
                    }
                }
            } catch (e: Exception){
                e.printStackTrace()
                stopLoading()
            }
        }
    }

    private fun showLoading(){
        _state.update {
            it.copy(
                loading = true
            )
        }
    }
    private fun stopLoading(){
        _state.update {
            it.copy(
                loading = false
            )
        }
    }
}