package com.example.data.bookss.books.repository


import com.example.data.bookss.books.store.CategoryNetworkDataSource

import com.example.domain.feature.books.books.model.AuthorsResponse
import com.example.domain.feature.books.books.repository.AuthorRepository


class AuthorsRepositoryImp(
    private val networkDataSource: CategoryNetworkDataSource


    ) : AuthorRepository {
    override suspend fun getAuthors(): AuthorsResponse {
        val networkBook = networkDataSource.getAuthorsFromApi()

        return networkBook

    }
}





















