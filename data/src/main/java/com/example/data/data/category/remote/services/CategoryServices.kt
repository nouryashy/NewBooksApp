package com.example.data.data.category.remote.service

import com.example.data.data.category.remote.model.CategoryBooksResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryServices {
    @GET("books")
    suspend fun getCategoryBooks(@Query("topic") topic: String)
            : CategoryBooksResponseModel
}