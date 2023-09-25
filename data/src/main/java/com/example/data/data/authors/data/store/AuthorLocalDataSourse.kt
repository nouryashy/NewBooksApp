package com.example.data.bookss.books.store

import com.example.data.data.books.cache.db.AuthorsDao
import com.example.data.data.books.cache.entity.CachedAuthors


class AuthorLocalDataSourse(val authorDao: AuthorsDao) {

    suspend fun getAuthorsFromDB(): List<CachedAuthors> {
        return authorDao.getAllAuthors()
    }

    suspend fun saveAuthorsToDb(authors: List<CachedAuthors>) {
        authorDao.insertAuthors(authors)
    }

    suspend fun deleteAuthor() {
        authorDao.clearAuthors()
    }

}