package com.example.domain.feature.books.feature.books.usecase

import com.example.domain.feature.books.feature.books.repository.BooksRepository
import javax.inject.Inject

class GetBooks @Inject constructor(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(page: Int) = booksRepository.getBooks(page)
}