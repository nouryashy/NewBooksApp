package com.example.data.books.books.repository

import com.example.data.books.books.cashe.mapper.BookMapper
import com.example.data.books.books.store.BookLocalDataSourse
import com.example.data.books.books.store.BookNetworkDataSource
import com.example.domain.feature.books.feature.books.model.BooksResponce
import com.example.domain.feature.books.feature.books.repository.BooksRepository


class BooksRepositoryImp(
    private val networkDataSource: BookNetworkDataSource,
    private val localDataSource: BookLocalDataSourse,
    private val mapper: BookMapper

) : BooksRepository {


    override suspend fun getBooks(page: Int): BooksResponce {
        val networkBook = networkDataSource.getBooksFromApi(page)
        return networkBook

    }



}



























