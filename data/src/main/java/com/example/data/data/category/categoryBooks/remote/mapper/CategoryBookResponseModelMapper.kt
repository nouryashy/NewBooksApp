package com.example.data.data.category.categoryBooks.remote.mapper

import com.example.data.data.books.remote.model.BookModel
import com.example.data.data.category.categoryBooks.remote.model.CategoryBookModel
import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.category.categorybooks.model.CategoryBook

object CategoryBookResponseModelMapper {
    fun mapFromEntity(entity: CategoryBookModel): CategoryBook {
        val formatEntity = CategoryFormatModelMapper.mapFromEntity(entity.formats)
        return CategoryBook(
            id = entity.id,
            formats = formatEntity,
            subjects = entity.subjects,
            title = entity.title
        )
    }

    fun mapToEntity(domain: CategoryBook): CategoryBookModel {
        val formatDomain = CategoryFormatModelMapper.mapToEntity(domain.formats)
        return CategoryBookModel(
            id = domain.id,
            formats = formatDomain,
            subjects = domain.subjects,
            title = domain.title,
        )
    }
}