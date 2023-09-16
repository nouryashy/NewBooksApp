package com.example.domain.feature.books.feature.books.usecase

import com.example.domain.feature.books.feature.books.repository.BooksRepository

class GetBooks(private val booksRepository: BooksRepository) {

    suspend operator fun invoke(page: Int) = booksRepository.getBooks(page)


}