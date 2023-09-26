package com.example.data.data.category.data.repository

import com.example.data.data.category.cache.mapper.CachedCategoryBookMapper
import com.example.data.data.category.data.store.CategoryBooksLocalDataSource
import com.example.data.data.category.data.store.CategoryBooksNetworkDataSource
import com.example.data.data.category.remote.mapper.CategoryBooksResponseModelMapper
import com.example.domain.feature.books.feature.category.model.CategoryBook
import com.example.domain.feature.books.feature.category.model.CategoryLabel
import com.example.domain.feature.books.feature.category.repository.CategoryRepository

class CategoryRepositoryImp(
    private val networkDataSource: CategoryBooksNetworkDataSource,
    private val localDataSource: CategoryBooksLocalDataSource,
    private val mapperRemote: CategoryBooksResponseModelMapper,
    private val mapperCached: CachedCategoryBookMapper
) : CategoryRepository {
    override fun getCategoriesLabel(): List<CategoryLabel> {
        return listOf(
            CategoryLabel(1, "Drama"),
            CategoryLabel(2, "Religious"),
            CategoryLabel(3, "History"),
            CategoryLabel(4, "Children"),
            CategoryLabel(5, "Fiction"),
            CategoryLabel(6, "Medicine"),
            CategoryLabel(7, "Sports"),
            CategoryLabel(8, "Cooking"),
            CategoryLabel(9, "Science"),
        )
    }

    override suspend fun getBooksAccordingToCategories(topic: String): List<CategoryBook> {
        return try {
            val networkBooks = networkDataSource.getCategoryFromApi(topic)
            val books = networkBooks.categoryBooks
            localDataSource.saveCategoryBooksToDb(books.map { mapperCached.mapFromCached(it) })
            books.map { mapperRemote.mapFromEntity(it) }
        } catch (e: Exception) {
            val cashed = localDataSource.getAllCategoryBooks()
            val cashedBooks = cashed.map { mapperCached.mapToCached(it) }
            cashedBooks.map { mapperRemote.mapFromEntity(it) }
        }
    }
}