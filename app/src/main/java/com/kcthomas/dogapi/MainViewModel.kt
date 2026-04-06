package com.kcthomas.dogapi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kcthomas.data.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    data class ViewState(
        val imageUrls: List<String> = emptyList()
    )

    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

    private val repository = DogRepository()

    init {
        loadDogs()
    }

    fun loadDogs() {
        viewModelScope.launch {
            val dogData = repository.getDogs()
            if (dogData != null) {
                _viewState.update {
                    it.copy(imageUrls = dogData.message.toList())
                }
            } else {
                // Error Handling
                Log.e(MainViewModel::class.java.simpleName, "Failed to acquire Dogs")
            }
        }
    }
}
