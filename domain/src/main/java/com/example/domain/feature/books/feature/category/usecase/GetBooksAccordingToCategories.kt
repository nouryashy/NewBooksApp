package com.example.domain.feature.books.feature.category.usecase

import com.example.domain.feature.books.feature.category.repository.CategoryRepository
import javax.inject.Inject

class GetBooksAccordingToCategories @Inject constructor(private val categoryRepository: CategoryRepository) {
    suspend operator fun invoke(topic: String) =
        categoryRepository.getBooksAccordingToCategories(topic)
}