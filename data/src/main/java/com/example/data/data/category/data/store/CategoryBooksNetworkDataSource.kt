package com.example.data.data.category.data.store

import com.example.data.data.category.remote.model.CategoryBooksResponseModel
import com.example.data.data.category.remote.service.CategoryServices

class CategoryBooksNetworkDataSource(val apiServices: CategoryServices) {
    suspend fun getCategoryFromApi(topic: String): CategoryBooksResponseModel =
        apiServices.getCategoryBooks(topic)
}