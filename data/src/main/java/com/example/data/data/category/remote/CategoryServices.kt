package com.example.data.bookss.books.remote


import com.example.domain.feature.books.books.model.AuthorsResponse
import retrofit2.http.GET


interface CategoryServices {
    @GET("books")
    suspend fun getAuthors(): AuthorsResponse

}