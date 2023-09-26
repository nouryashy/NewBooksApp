package com.example.data.data.category.remote.mapper

import com.example.data.data.books.remote.mapper.FormatModelMapper
import com.example.data.data.category.remote.model.CategoryBookModel
import com.example.domain.feature.books.feature.category.model.CategoryBook

object CategoryBooksResponseModelMapper {
    fun mapFromEntity(entity: CategoryBookModel): CategoryBook {
        val formatEntity = FormatCategoryModelMapper.mapFromEntity(entity.formats)
        return CategoryBook(
            id = entity.id,
            formats = formatEntity,
            subjects =entity.subjects,
            title = entity.title

        )
    }

    fun mapToEntity(domain: CategoryBook): CategoryBookModel {
        val formatDomain = FormatCategoryModelMapper.mapToEntity(domain.formats)
        return CategoryBookModel(
            id = domain.id,
            formats = formatDomain,
            subjects =domain.subjects,
            title = domain.title,
        )
    }

}