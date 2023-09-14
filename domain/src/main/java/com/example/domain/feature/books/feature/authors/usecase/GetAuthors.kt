package com.example.domain.feature.books.books.usecase

import com.example.domain.feature.books.books.repository.AuthorRepository
import com.example.domain.feature.books.feature.books.repository.BooksRepository

class GetAuthors(private val authorRepository: AuthorRepository) {

    suspend operator fun invoke() = authorRepository.getAuthors()

}