package com.example.postsappdemo.state

import androidx.lifecycle.MutableLiveData
import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.books.model.BooksResponce
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val exception: Throwable) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}


