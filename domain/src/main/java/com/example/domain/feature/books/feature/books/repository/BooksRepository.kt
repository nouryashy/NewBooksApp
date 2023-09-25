package com.example.domain.feature.books.feature.books.repository
import com.example.domain.feature.books.feature.books.model.Book

interface BooksRepository {
    suspend fun getBooks(page: Int): List<Book>
}