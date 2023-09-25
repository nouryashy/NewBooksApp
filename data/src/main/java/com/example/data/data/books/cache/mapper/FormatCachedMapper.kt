package com.example.data.data.books.cache.mapper

import com.example.data.data.books.cache.entity.CachedBook
import com.example.data.data.books.remote.model.BookModel

object FormatCachedMapper {
    fun mapFromCached(type: BookModel.FormatsModel): CachedBook.FormatsCached {
        return CachedBook.FormatsCached(
            imageJPEG = type.imageJPEG
        )
    }

    fun mapToCached(entity: CachedBook.FormatsCached): BookModel.FormatsModel {
        return BookModel.FormatsModel(
            imageJPEG = entity.imageJPEG
        )
    }
}