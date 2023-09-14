package com.example.data.bookss.books.repository


import com.example.data.bookss.books.store.AuthorNetworkDataSource

import com.example.domain.feature.books.books.model.Authors
import com.example.domain.feature.books.books.model.AuthorsResponce
import com.example.domain.feature.books.books.repository.AuthorRepository
import com.example.domain.feature.books.feature.books.model.Author
import com.example.domain.feature.books.feature.books.model.BooksResponce
import retrofit2.Response


class AuthorsRepositoryImp(
    private val networkDataSource: AuthorNetworkDataSource


    ) : AuthorRepository {
    override suspend fun getAuthors(): AuthorsResponce {
        val networkBook = networkDataSource.getAuthorsFromApi()

        return networkBook

    }
}





















