package com.example.data.bookss.books.remote


import com.example.domain.feature.books.books.model.AuthorsResponce
import retrofit2.http.GET


interface AuthorsServices {
    @GET("books")
    suspend fun getAuthors(): AuthorsResponce

}