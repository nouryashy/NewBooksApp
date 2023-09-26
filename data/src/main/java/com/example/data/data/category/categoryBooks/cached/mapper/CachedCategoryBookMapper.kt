package com.example.data.data.category.cache.mapper
import com.example.data.data.category.cache.entity.CachedCategoryBook
import com.example.data.data.category.categoryBooks.cached.mapper.CachedFormatCategoryBookMapper
import com.example.data.data.category.categoryBooks.remote.model.CategoryBookModel

object CachedCategoryBookMapper {
    fun mapFromCached(type: CategoryBookModel): CachedCategoryBook {
        val formatModel = CachedFormatCategoryBookMapper.mapFromCached(type.formats)
        return CachedCategoryBook(
            id = type.id,
            formats = formatModel,
            subjects = type.subjects,
            title = type.title
        )
    }
    fun mapToCached(entity: CachedCategoryBook): CategoryBookModel {
        val formatCashed = CachedFormatCategoryBookMapper.mapToCached(entity.formats)
        return CategoryBookModel(
            id = entity.id,
            formats = formatCashed,
            subjects = entity.subjects,
            title = entity.title,
        )
    }
}