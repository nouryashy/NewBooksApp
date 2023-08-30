package com.example.domain.feature.books.usecase

import com.example.domain.feature.books.repository.BooksRepository

class GetBooks(private val booksRepository: BooksRepository) {

    suspend operator fun invoke() = booksRepository.getBooks()

}