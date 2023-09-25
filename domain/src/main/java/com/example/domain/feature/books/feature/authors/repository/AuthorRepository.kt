package com.example.domain.feature.books.books.repository

import com.example.domain.feature.books.books.model.Authors

interface AuthorRepository {
    suspend fun getAuthors(): List<Authors>

}