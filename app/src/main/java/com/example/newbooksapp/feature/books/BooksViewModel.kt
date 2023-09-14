package com.example.newbooksapp.feature.books

import androidx.lifecycle.*
import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.books.repository.BooksRepository
import com.example.domain.feature.books.feature.books.usecase.GetBooks

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getBooksUseCase: GetBooks,
    private val repository: BooksRepository
) :
    ViewModel() {
//    private var _books = MutableStateFlow<Resource<List<Book>>>(Resource.Loading)
//    val books: StateFlow<Resource<List<Book>>> = _books


    private var _books: MutableStateFlow<List<Book>?> = MutableStateFlow(null)
    val books: StateFlow<List<Book>?> = _books

    //
    var currentPage = 1


//    fun getBooks() {
//        viewModelScope.launch(Dispatchers.IO) {
//            _books.value = Resource.Loading
//            try {
//                val books = getBooksUseCase(currentPage)
//                _books.value = Resource.Success(books + _books.value) as Resource<List<Book>>
//                Log.d(TAG, "viewModel: " + _books.toString())
//            } catch (e: Exception) {
//                _books.value = Resource.Error(e)
//                Log.e(TAG, "_books: " + e)
//            }
//        }
//    }

    fun loadNextPage() {
        viewModelScope.launch{
            try {
                val response = getBooksUseCase(currentPage)
                val newList = response.books
                _books.value = _books.value.orEmpty() + newList

                // Update the current page if there's a "next" value in the response
                response.next?.let {
                    currentPage++
                }
            } catch (e: Exception) {
                // Handle error
            }
        }


}
    }








