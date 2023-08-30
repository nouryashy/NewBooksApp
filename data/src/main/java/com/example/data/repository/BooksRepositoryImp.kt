package com.example.data.repository

import com.example.data.entity.BookEntity
import com.example.data.mapper.BookMapper
import com.example.data.store.LocalDataSourse
import com.example.data.store.NetworkDataSource
import com.example.domain.feature.books.model.Book
import com.example.domain.feature.books.model.BooksResponce
import com.example.domain.feature.books.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map


class BooksRepositoryImp(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSourse,
    private val mapper: BookMapper

) : BooksRepository {


    override suspend fun getBooks(): List<Book> {

        val cashedBooks = localDataSource.getBookFromDB()
        if (cashedBooks.count() != null) {
            return cashedBooks.map { mapper.mapEntityToDomain(it) }
        } else {
            val networkBooks = networkDataSource.getBooksFromApi().books
            val cachedEntities = networkBooks!!.map {
                mapper.mapDomainToEntity(it)
            }

            localDataSource.saveBooksToDb(cachedEntities!! as List<BookEntity>)

            return networkBooks
        }

    }
}