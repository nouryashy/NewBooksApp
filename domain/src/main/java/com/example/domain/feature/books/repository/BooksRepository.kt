package com.example.domain.feature.books.repository

import com.example.domain.feature.books.model.Book
import com.example.domain.feature.books.model.BooksResponce
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    suspend fun getBooks(): List<Book>

}