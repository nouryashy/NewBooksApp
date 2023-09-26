package com.example.domain.feature.books.feature.category.categorybooks.usecase

import com.example.domain.feature.books.feature.category.categorybooks.repository.CategoryBooksRepository
import javax.inject.Inject

class GetBooksAccordingToCategories
@Inject constructor(private val categoryBookRepository: CategoryBooksRepository) {
    suspend operator fun invoke(topic: String) =
        categoryBookRepository.getBooksAccordingToCategories(topic)
}