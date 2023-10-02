package com.example.domain.feature.books.books.repository

import com.example.domain.feature.books.books.model.Authors
import kotlinx.coroutines.flow.Flow

interface AuthorRepository {
    suspend fun getAuthors(): List<Authors>


}