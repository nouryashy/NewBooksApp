package com.example.data.books.books.cashe.db

import androidx.room.*
import com.example.data.books.books.cashe.entity.BookEntity

@Database(entities = [BookEntity::class], version = 1,exportSchema = true)
@TypeConverters(Converters::class)

abstract class BooksDatabase : RoomDatabase() {
    abstract fun BooksDao(): BooksDao
}