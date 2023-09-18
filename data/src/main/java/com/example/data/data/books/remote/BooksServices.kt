package com.example.data.data.books.remote


import com.example.domain.feature.books.feature.books.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface BooksServices {
    @GET("books")
    suspend fun getBooks(@Query("page") page: Int)
            : BooksResponse



//    @GET
//    suspend fun getBooks(@Url url: String): Response<BooksResponce>

}