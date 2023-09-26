package com.example.data.data.category.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.data.category.cache.entity.CachedCategoryBook

@Dao
interface CategoryBooksDao {
    @Query("SELECT * FROM categories")
    suspend fun getAllCategoryBooks(): List<CachedCategoryBook>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategoryBooks(categoryBooks: List<CachedCategoryBook>)
    @Query("DELETE FROM categories")
    suspend fun clearCategoryBook()
}