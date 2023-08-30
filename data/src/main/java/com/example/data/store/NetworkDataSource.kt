package com.example.data.store

import com.example.data.remote.ApiServices
import com.example.domain.feature.books.model.Book
import com.example.domain.feature.books.model.BooksResponce
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NetworkDataSource(val apiServices: ApiServices) {

    suspend fun getBooksFromApi(): BooksResponce = apiServices.getBooks()


}