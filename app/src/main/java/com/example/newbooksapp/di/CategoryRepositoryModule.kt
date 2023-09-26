package com.example.newbooksapp.di

import com.example.data.data.books.cache.db.BooksDao
import com.example.data.data.books.cache.mapper.CachedBookMapper
import com.example.data.data.books.data.store.BookLocalDataSource
import com.example.data.data.books.data.store.BookNetworkDataSource
import com.example.data.data.books.remote.mapper.BookResponseModelMapper
import com.example.data.data.books.remote.service.BooksServices
import com.example.data.data.category.cache.db.CategoryBooksDao
import com.example.data.data.category.cache.mapper.CachedCategoryBookMapper
import com.example.data.data.category.data.repository.CategoryRepositoryImp
import com.example.data.data.category.data.store.CategoryBooksLocalDataSource
import com.example.data.data.category.data.store.CategoryBooksNetworkDataSource
import com.example.data.data.category.remote.mapper.CategoryBooksResponseModelMapper
import com.example.data.data.category.remote.service.CategoryServices
import com.example.domain.feature.books.feature.category.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CategoryRepositoryModule {


    @Provides
    fun provideCatBookNetworkDataSource(apiService: CategoryServices): CategoryBooksNetworkDataSource {
        return CategoryBooksNetworkDataSource(apiService)
    }

    @Provides
    fun provideCatBookLocalDataSource(dao: CategoryBooksDao): CategoryBooksLocalDataSource {
        return CategoryBooksLocalDataSource(dao)
    }

    @Provides
    fun provideCatCachedBookMapper(): CachedCategoryBookMapper {
        return CachedCategoryBookMapper
    }


    @Provides
    fun provideCatBookBookMapper(): CategoryBooksResponseModelMapper {
        return CategoryBooksResponseModelMapper
    }

    @Provides
    fun provideCategoryRepository(
        networkDataSource: CategoryBooksNetworkDataSource,
        localDataSourse: CategoryBooksLocalDataSource,
        mapperRemote: CategoryBooksResponseModelMapper,
        mapperCached: CachedCategoryBookMapper
    ): CategoryRepository {
        return CategoryRepositoryImp(networkDataSource, localDataSourse, mapperRemote, mapperCached)
    }
}