package com.example.data.data.category.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.data.category.cache.entity.CachedCategoryBook

@Database(entities = [CachedCategoryBook::class], version = 1,exportSchema = true)
@TypeConverters(CategoryBooksConverters::class)

abstract class CategoryBooksDataBase : RoomDatabase() {
    abstract fun categoryBooksDao(): CategoryBooksDao
}