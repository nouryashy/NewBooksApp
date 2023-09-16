package com.example.data.books.books.repository

import com.example.data.books.books.cashe.mapper.BookMapper
import com.example.data.books.books.store.BookLocalDataSourse
import com.example.data.books.books.store.BookNetworkDataSource
import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.books.repository.BooksRepository


class BooksRepositoryImp(
    private val networkDataSource: BookNetworkDataSource,
    private val localDataSource: BookLocalDataSourse,
    private val mapper: BookMapper

) : BooksRepository {

    override suspend fun getBooks(page: Int): List<Book> {

//        val networkBooks = networkDataSource.getBooksFromApi(page)
//        val books = networkBooks.books
//        return if (books.isNotEmpty()) {
//            localDataSource.saveBooksToDb(books.map { mapper.mapDomainToEntity(it) })
//
//            books
//        } else {
//            val cashed = localDataSource.getBookFromDB()
//            cashed.map { mapper.mapEntityToDomain(it) }
//        }


        val cashed = localDataSource.getBookFromDB()
        if (cashed.isNotEmpty()) {
            return cashed.map { mapper.mapEntityToDomain(it) }
        } else {
            val networkBooks = networkDataSource.getBooksFromApi(page)
            val books = networkBooks.books
            localDataSource.saveBooksToDb(books.map { mapper.mapDomainToEntity(it) })
            return books



        }

    }

}



























