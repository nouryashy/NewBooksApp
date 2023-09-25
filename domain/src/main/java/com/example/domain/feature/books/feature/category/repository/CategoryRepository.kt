package com.example.domain.feature.books.feature.category.repository
import com.example.domain.feature.books.feature.category.model.CategoryLabel

interface CategoryRepository {
     fun getCategoriesLabel(): List<CategoryLabel>
}