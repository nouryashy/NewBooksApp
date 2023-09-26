package com.example.data.data.category.remote.mapper

import com.example.data.data.books.remote.model.BookModel
import com.example.data.data.category.remote.model.CategoryBookModel
import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.category.model.CategoryBook

object FormatCategoryModelMapper {
    fun mapFromEntity(entity: CategoryBookModel.FormatsCatModel): CategoryBook.FormatsCat {
        return CategoryBook.FormatsCat(
            imageJPEG = entity.imageJPEG
        )
    }

    fun mapToEntity(domain:  CategoryBook.FormatsCat): CategoryBookModel.FormatsCatModel {
        return CategoryBookModel.FormatsCatModel(
            imageJPEG = domain.imageJPEG
        )
    }
}