package com.example.data.db

import androidx.room.*
import com.example.data.entity.BookEntity
import com.example.domain.feature.books.model.Book

@Database(entities = [BookEntity::class], version = 1,exportSchema = true)
@TypeConverters(Converters::class)

abstract class BooksDatabase : RoomDatabase() {
    abstract fun BooksDao(): BooksDao
}