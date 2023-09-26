package com.example.domain.feature.books.feature.category.categorybooks.repository

import com.example.domain.feature.books.feature.category.categorybooks.model.CategoryBook

interface CategoryBooksRepository {
    suspend fun getBooksAccordingToCategories(topic: String): List<CategoryBook>
}