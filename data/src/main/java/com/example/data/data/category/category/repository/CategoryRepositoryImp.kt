package com.example.data.data.category.categoryBooks.data.repository

import com.example.domain.feature.books.feature.category.categorybooks.model.CategoryLabel
import com.example.domain.feature.books.feature.category.categorybooks.repository.CategoryRepository

class CategoryRepositoryImp(
) : CategoryRepository {
    override fun getCategoriesLabel(): List<CategoryLabel> {
        return listOf(
            CategoryLabel(1, "Drama"),
            CategoryLabel(2, "Religious"),
            CategoryLabel(3, "History"),
            CategoryLabel(4, "Children"),
            CategoryLabel(5, "Fiction"),
            CategoryLabel(6, "Medicine"),
            CategoryLabel(7, "Sports"),
            CategoryLabel(8, "Cooking"),
            CategoryLabel(9, "Science"),
        )
    }


}