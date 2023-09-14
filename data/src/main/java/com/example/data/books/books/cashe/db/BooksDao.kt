package com.example.data.books.books.cashe.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.books.books.cashe.entity.BookEntity


@Dao
interface BooksDao {
    @Query("SELECT * FROM books")
     fun getAllBooks(): List<BookEntity>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertBooks(books: List<BookEntity>)
}

