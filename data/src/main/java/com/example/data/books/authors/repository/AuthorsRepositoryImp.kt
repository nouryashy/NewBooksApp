package com.example.data.bookss.books.repository


import com.example.data.bookss.books.store.AuthorNetworkDataSource

import com.example.domain.feature.books.books.model.AuthorsResponce
import com.example.domain.feature.books.books.repository.AuthorRepository


class AuthorsRepositoryImp(
    private val networkDataSource: AuthorNetworkDataSource


    ) : AuthorRepository {
    override suspend fun getAuthors(): AuthorsResponce {
        val networkBook = networkDataSource.getAuthorsFromApi()

        return networkBook

    }
}





















