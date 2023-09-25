package com.example.data.data.books.remote.mapper

import com.example.data.data.books.remote.model.BookModel
import com.example.domain.feature.books.feature.books.model.Book

object FormatModelMapper {
    fun mapFromEntity(entity: BookModel.FormatsModel): Book.Formats {
        return Book.Formats(
            imageJPEG = entity.imageJPEG
        )
    }

    fun mapToEntity(domain: Book.Formats): BookModel.FormatsModel {
        return BookModel.FormatsModel(
            imageJPEG = domain.imageJPEG
        )
    }
}