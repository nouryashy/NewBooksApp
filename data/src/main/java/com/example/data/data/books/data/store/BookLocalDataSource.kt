package com.example.data.data.books.data.store

import com.example.data.data.books.cache.db.BooksDao
import com.example.data.data.books.cache.entity.CachedBook

class BookLocalDataSource(val bookDao: BooksDao) {
    suspend  fun getBookFromDB(): List<CachedBook> {
        return bookDao.getAllBooks()
    }

    suspend  fun saveBooksToDb(books: List<CachedBook>) {
        bookDao.insertBooks(books)
    }

    suspend  fun deleteBooks(){
        return bookDao.clearBooks()
    }
}