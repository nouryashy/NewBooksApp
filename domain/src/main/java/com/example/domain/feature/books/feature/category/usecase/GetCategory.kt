package com.example.domain.feature.books.feature.category.usecase

import com.example.domain.feature.books.feature.books.repository.BooksRepository
import com.example.domain.feature.books.feature.category.repository.CategoryRepository

class GetCategory(private val categoryRepository: CategoryRepository) {

    suspend operator fun invoke() = categoryRepository.getCategory()
}