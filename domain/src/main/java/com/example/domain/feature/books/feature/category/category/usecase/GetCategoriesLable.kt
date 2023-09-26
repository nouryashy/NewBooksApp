package com.example.domain.feature.books.feature.category.categorybooks.usecase
import com.example.domain.feature.books.feature.category.categorybooks.model.CategoryLabel
import com.example.domain.feature.books.feature.category.categorybooks.repository.CategoryRepository
import javax.inject.Inject

class GetCategoriesLable
@Inject constructor(private val categoryRepository: CategoryRepository) {
    fun execute(): List<CategoryLabel> {
        return categoryRepository.getCategoriesLabel()
    }
}