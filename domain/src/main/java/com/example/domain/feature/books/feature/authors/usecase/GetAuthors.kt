package com.example.domain.feature.books.feature.authors.usecase

import com.example.domain.feature.books.books.repository.AuthorRepository

class GetAuthors(private val authorRepository: AuthorRepository) {

    suspend operator fun invoke() = authorRepository.getAuthors()

}