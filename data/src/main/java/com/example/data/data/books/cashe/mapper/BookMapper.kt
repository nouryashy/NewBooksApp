package com.example.data.data.books.cashe.mapper

import com.example.data.data.books.cashe.entity.BookEntity
import com.example.domain.feature.books.feature.books.model.Book


object BookMapper {
    fun mapEntityToDomain(entity: BookEntity): Book {
        return Book(
            id = entity.id,
            formats = entity.formats,
            subjects = entity.subjects,
            title = entity.title
        )
    }

    fun mapDomainToEntity(domain: Book): BookEntity {
        return BookEntity(
            id = domain.id,
            formats = domain.formats,
            subjects = domain.subjects,
            title = domain.title,
        )
    }

    fun mapEntityListToDomainList(entities: List<BookEntity>): List<Book> {
        return entities.map { mapEntityToDomain(it) }
    }

    fun mapDomainListToEntityList(domains: List<Book>): List<BookEntity> {
        return domains.map { mapDomainToEntity(it) }
    }
}