package com.example.data.data.category.categoryBooks.data.store

import com.example.data.data.category.categoryBooks.remote.model.CategoryBooksResponseModel
import com.example.data.data.category.remote.service.CategoryServices

class CategoryBooksNetworkDataSource(val apiServices: CategoryServices) {
    suspend fun getCategoryFromApi(topic: String): CategoryBooksResponseModel =
        apiServices.getCategoryBooks(topic)
}