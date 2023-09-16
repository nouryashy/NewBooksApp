package com.example.domain.feature.books.feature.books.repository


import com.example.domain.feature.books.books.model.AuthorsResponce
import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.books.model.BooksResponce
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    suspend fun getBooks(page: Int): List<Book>



}