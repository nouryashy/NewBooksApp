package com.example.newbooksapp.feature.auther

import androidx.lifecycle.*
import com.example.domain.feature.books.books.model.Authors
import com.example.domain.feature.books.feature.authors.usecase.GetAuthors
import com.example.domain.feature.books.feature.books.model.Book
import com.example.postsappdemo.state.Resource

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorsViewModel @Inject constructor(
    private val getAuthorsUseCase: GetAuthors,
) :
    ViewModel() {
    private var _authors = MutableStateFlow<Resource<List<Authors>>>(Resource.Loading)
    val authors: StateFlow<Resource<List<Authors>>> = _authors


    fun getAuthors() {
        viewModelScope.launch {
            try {
                val autherList = getAuthorsUseCase()
                _authors.value = Resource.Success(autherList)

                // Update the current page if there's a "next" value in the response
            } catch (e: Exception) {
                _authors.value = Resource.Error(e)
            }
        }
    }


}








