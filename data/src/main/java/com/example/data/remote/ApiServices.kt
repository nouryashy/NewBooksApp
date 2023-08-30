package com.example.data.remote


import com.example.domain.feature.books.model.Book
import com.example.domain.feature.books.model.BooksResponce
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServices {
    @GET("books")
    suspend fun getBooks(): BooksResponce
}