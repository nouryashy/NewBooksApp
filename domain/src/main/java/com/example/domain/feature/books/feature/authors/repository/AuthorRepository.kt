package com.example.domain.feature.books.books.repository

import com.example.domain.feature.books.books.model.AuthorsResponse

interface AuthorRepository {

    suspend fun getAuthors(): AuthorsResponse

}