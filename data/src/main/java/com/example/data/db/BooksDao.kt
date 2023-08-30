package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.entity.BookEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface BooksDao {
    @Query("SELECT * FROM books")
    suspend fun getAllBooks(): List<BookEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: List<BookEntity>)
}

