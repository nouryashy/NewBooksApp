package com.example.domain.feature.books.feature.authors.usecase


import com.example.domain.feature.books.books.repository.AuthorRepository
import javax.inject.Inject

class GetAuthors
@Inject constructor(private val authorRepository: AuthorRepository)
{
    suspend operator fun invoke() = authorRepository.getAuthors()
}