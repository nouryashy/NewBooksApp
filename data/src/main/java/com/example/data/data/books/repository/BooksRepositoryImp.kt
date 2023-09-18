package com.example.data.data.books.repository

import com.example.data.data.books.cashe.mapper.BookMapper
import com.example.data.data.books.store.BookLocalDataSourse
import com.example.data.data.books.store.BookNetworkDataSource
import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.books.repository.BooksRepository


class BooksRepositoryImp(
    private val networkDataSource: BookNetworkDataSource,
    private val localDataSource: BookLocalDataSourse,
    private val mapper: BookMapper

) : BooksRepository {


    override suspend fun getBooks(page: Int): List<Book> {

        val cashed = localDataSource.getBookFromDB()
        localDataSource.deleteBooks()
        if (cashed.isNotEmpty()) {
            return cashed.map { mapper.mapEntityToDomain(it) }
        } else {
            val networkBooks = networkDataSource.getBooksFromApi(page)
            val books = networkBooks.books
            localDataSource.saveBooksToDb(books.map { mapper.mapDomainToEntity(it) })
            return books
        }

    }


//        val networkBooks = networkDataSource.getBooksFromApi(page)
//        val books = networkBooks.books
//        return if (books.isNotEmpty()) {
//                localDataSource.deleteBooks()
//                localDataSource.saveBooksToDb(books.map { mapper.mapDomainToEntity(it) })
//            books
//        } else {
//            val cashed = localDataSource.getBookFromDB()
//            val cashedBooks = cashed.map { mapper.mapEntityToDomain(it) }
//            return cashedBooks
//
//
//        }

}



























