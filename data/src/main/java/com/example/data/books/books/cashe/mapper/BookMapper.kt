package com.example.data.books.books.cashe.mapper

import com.example.data.books.books.cashe.entity.BookEntity
import com.example.domain.feature.books.feature.books.model.Book


object BookMapper {
    fun mapEntityToDomain(entity: BookEntity): Book {
        return Book(
            id = entity.id,
//            authors = entity.authors ,
//            bookshelves = entity.bookshelves,
//            copyright = entity.copyright,
//            download_count = entity.download_count,
            formats = entity.formats,
//            languages = entity.languages,
//            media_type = entity.media_type,
            subjects = entity.subjects,
            title = entity.title,
//            translators = entity.translators
        )
    }

    fun mapDomainToEntity(domain: Book): BookEntity {
        return BookEntity(
            id = domain.id,
//            authors = domain.authors ,
//            bookshelves = domain.bookshelves,
//            copyright = domain.copyright,
//            download_count = domain.download_count,
            formats = domain.formats,
//            languages = domain.languages,
//            media_type = domain.media_type,
            subjects = domain.subjects,
            title = domain.title,
//            translators = domain.translators
        )
    }

    fun mapEntityListToDomainList(entities: List<BookEntity>): List<Book> {
        return entities.map { mapEntityToDomain(it) }
    }

    fun mapDomainListToEntityList(domains: List<Book>): List<BookEntity> {
        return domains.map { mapDomainToEntity(it) }
    }
}