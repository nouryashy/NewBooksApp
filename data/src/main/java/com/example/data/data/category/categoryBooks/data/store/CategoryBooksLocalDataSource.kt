package com.example.data.data.category.categoryBooks.data.store
import com.example.data.data.category.cache.db.CategoryBooksDao
import com.example.data.data.category.cache.entity.CachedCategoryBook

class CategoryBooksLocalDataSource(val categoryDao: CategoryBooksDao) {
    suspend fun getAllCategoryBooks(): List<CachedCategoryBook> {
        return categoryDao.getAllCategoryBooks()
    }

    suspend fun saveCategoryBooksToDb(categoryBooks: List<CachedCategoryBook>) {
        categoryDao.insertCategoryBooks(categoryBooks)
    }

    suspend fun deleteCategoryBook() {
        return categoryDao.clearCategoryBook()
    }

}