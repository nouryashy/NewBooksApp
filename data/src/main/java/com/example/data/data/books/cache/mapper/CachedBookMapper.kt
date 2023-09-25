package com.example.data.data.books.cache.mapper

import com.example.data.data.books.cache.entity.CachedBook
import com.example.data.data.books.remote.model.BookModel


object CachedBookMapper {
    fun mapFromCached(type: BookModel): CachedBook {
        val formatModel = FormatCachedMapper.mapFromCached(type.formats)


    return CachedBook(
    id = type.id,
    formats = formatModel,
    subjects = type.subjects,
    title = type.title
    )
}

fun mapToCached(entity: CachedBook): BookModel {
    val formatCashed = FormatCachedMapper.mapToCached(entity.formats)
    return BookModel(
        id = entity.id,
        formats = formatCashed,
        subjects = entity.subjects,
        title = entity.title,
    )
}
}