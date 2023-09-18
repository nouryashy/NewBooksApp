package com.example.newbooksapp.feature.auther

import androidx.lifecycle.*
import com.example.domain.feature.books.books.model.Authors
import com.example.domain.feature.books.feature.authors.usecase.GetAuthors

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorsViewModel @Inject constructor(
    private val getAuthorsUseCase: GetAuthors,
) :
    ViewModel() {
    private var _authors: MutableStateFlow<List<Authors>?> = MutableStateFlow(null)
    val authors: StateFlow<List<Authors>?> = _authors


    fun getAuthors() {
        viewModelScope.launch {
            try {
                _authors.value = getAuthorsUseCase().authors

                // Update the current page if there's a "next" value in the response
            } catch (e: Exception) {
                // Handle error
            }
        }


    }
}








