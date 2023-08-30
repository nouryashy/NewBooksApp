package com.example.data.store

import com.example.data.db.BooksDao
import com.example.data.entity.BookEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSourse(val bookDao: BooksDao) {

    suspend fun getBookFromDB(): List<BookEntity> {
        return bookDao.getAllBooks()
    }

    suspend fun saveBooksToDb(books: List<BookEntity>) {
        bookDao.insertBooks(books)
    }
}