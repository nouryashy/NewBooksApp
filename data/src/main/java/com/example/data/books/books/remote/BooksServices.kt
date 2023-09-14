package com.example.data.books.books.remote


import com.example.domain.feature.books.feature.books.model.BooksResponce
import retrofit2.http.GET
import retrofit2.http.Query


interface BooksServices {
    @GET("books")
    suspend fun getBooks(@Query("page") page: Int)
    : BooksResponce



//    @GET
//    suspend fun getBooks(@Url url: String): Response<BooksResponce>
}