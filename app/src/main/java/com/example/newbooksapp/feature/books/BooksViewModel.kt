package com.example.newbooksapp.feature.books

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.domain.feature.books.model.Book
import com.example.domain.feature.books.model.BooksResponce
import com.example.domain.feature.books.usecase.GetBooks
import com.example.postsappdemo.state.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val getBooksUseCase: GetBooks) :
    ViewModel() {
    private val _booksState = MutableStateFlow<Resource<List<Book>>?>(Resource.Loading)
    val booksState: StateFlow<Resource<List<Book>>?> = _booksState

    fun getBooks() {
        viewModelScope.launch {
            _booksState.value = Resource.Loading
            try {
                val books = getBooksUseCase()
                _booksState.value = Resource.Success(books) as Resource<List<Book>>
                Log.d(TAG, "viewModel: " + _booksState.toString())
            } catch (e: Exception) {
                _booksState.value = Resource.Error(e)
                Log.e(TAG, "_books: " + e)
            }
        }
    }

}


