package com.example.domain.feature.books.feature.category.usecase
import com.example.domain.feature.books.feature.category.model.CategoryLabel
import com.example.domain.feature.books.feature.category.repository.CategoryRepository
import javax.inject.Inject

class GetCategoriesLable
@Inject constructor(private val categoryRepository: CategoryRepository) {
    fun execute(): List<CategoryLabel> {
        return categoryRepository.getCategoriesLabel()
    }
}