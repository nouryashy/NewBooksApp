package com.example.data.data.category.data.repository
import com.example.domain.feature.books.feature.category.model.CategoryLabel
import com.example.domain.feature.books.feature.category.repository.CategoryRepository

class CategoryRepositoryImp ()
    :CategoryRepository
{
        override  fun getCategoriesLabel(): List<CategoryLabel> {
            return listOf(
                CategoryLabel(1,"Drama"),
                CategoryLabel(2,"Fiction"),
                CategoryLabel(3,"History"),
                CategoryLabel(4,"Medicine"),
                CategoryLabel(5,"Religious")
            )
        }
    }