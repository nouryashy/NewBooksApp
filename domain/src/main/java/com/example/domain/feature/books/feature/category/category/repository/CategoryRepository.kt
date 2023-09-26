package com.example.domain.feature.books.feature.category.categorybooks.repository

import com.example.domain.feature.books.feature.category.categorybooks.model.CategoryLabel

interface CategoryRepository {
    fun getCategoriesLabel(): List<CategoryLabel>

}