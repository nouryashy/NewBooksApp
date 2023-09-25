package com.example.newbooksapp.feature.books

import androidx.lifecycle.*
import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.books.usecase.GetBooks
import com.example.postsappdemo.state.Resource

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Math.ceil
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getBooksUseCase: GetBooks) :
    ViewModel() {
    private var _books = MutableStateFlow<Resource<List<Book>>>(Resource.Loading)
    val books: StateFlow<Resource<List<Book>>> = _books
    var currentPage = 1
    fun loadBooks() {
        _books.value = Resource.Loading
        viewModelScope.launch {
            try {
                val bookList = getBooksUseCase(currentPage)
                _books.value = Resource.Success(bookList)
            } catch (e: Exception) {
                _books.value = Resource.Error(e)
            }
        }
    }


    fun loadNextPage() {
        currentPage++
        loadBooks()
    }


}








