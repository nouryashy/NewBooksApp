package com.example.domain.feature.books.books.repository

import com.example.domain.feature.books.books.model.AuthorsResponce

interface AuthorRepository {

    suspend fun getAuthors(): AuthorsResponce

}