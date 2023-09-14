package com.example.data.books.books.store

import com.example.data.books.books.cashe.db.BooksDao
import com.example.data.books.books.cashe.entity.BookEntity

class BookLocalDataSourse(val bookDao: BooksDao) {

     fun getBookFromDB(): List<BookEntity> {
        return bookDao.getAllBooks()
    }

     fun saveBooksToDb(books: List<BookEntity>) {
        bookDao.insertBooks(books)
    }
}