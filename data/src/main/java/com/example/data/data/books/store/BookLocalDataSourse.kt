package com.example.data.data.books.store

import com.example.data.data.books.cashe.db.BooksDao
import com.example.data.data.books.cashe.entity.BookEntity

class BookLocalDataSourse(val bookDao: BooksDao) {

    suspend  fun getBookFromDB(): List<BookEntity> {
        return bookDao.getAllBooks()
    }

    suspend  fun saveBooksToDb(books: List<BookEntity>) {
        bookDao.insertBooks(books)
    }

    suspend  fun deleteBooks(){
        return bookDao.clearBooks()
    }
}