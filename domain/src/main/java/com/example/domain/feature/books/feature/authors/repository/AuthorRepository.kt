package com.example.domain.feature.books.books.repository

import com.example.domain.feature.books.books.model.Authors
import com.example.domain.feature.books.books.model.AuthorsResponce
import com.example.domain.feature.books.feature.books.model.Author
import com.example.domain.feature.books.feature.books.model.BooksResponce
import retrofit2.Response

interface AuthorRepository {

    suspend fun getAuthors(): AuthorsResponce

}