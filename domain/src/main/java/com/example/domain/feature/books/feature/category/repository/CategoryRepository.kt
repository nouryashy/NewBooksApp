package com.example.domain.feature.books.feature.category.repository

import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.category.model.Category

interface CategoryRepository {


    suspend fun getCategory(): List<Category>
}