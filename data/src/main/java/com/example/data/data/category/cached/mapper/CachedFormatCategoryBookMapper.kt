package com.example.data.data.category.cached.mapper

import com.example.data.data.category.cache.entity.CachedCategoryBook
import com.example.data.data.category.remote.model.CategoryBookModel

object CachedFormatCategoryBookMapper {
    fun mapFromCached(type: CategoryBookModel.FormatsCatModel): CachedCategoryBook.CachedFormatsCat {
        return CachedCategoryBook.CachedFormatsCat(
            imageJPEG = type.imageJPEG
        )
    }
    fun mapToCached(entity: CachedCategoryBook.CachedFormatsCat): CategoryBookModel.FormatsCatModel {
        return CategoryBookModel.FormatsCatModel(
            imageJPEG = entity.imageJPEG
        )
    }
}