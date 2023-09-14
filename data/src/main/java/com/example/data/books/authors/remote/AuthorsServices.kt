package com.example.data.bookss.books.remote


import com.example.domain.feature.books.books.model.Authors
import com.example.domain.feature.books.books.model.AuthorsResponce
import com.example.domain.feature.books.feature.books.model.Author
import com.example.domain.feature.books.feature.books.model.BooksResponce
import retrofit2.Response
import retrofit2.http.GET


interface AuthorsServices {
    @GET("books")
    suspend fun getAuthors(): AuthorsResponce

}