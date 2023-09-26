package com.example.newbooksapp.di

import com.example.data.data.category.cache.db.CategoryBooksDao
import com.example.data.data.category.cache.mapper.CachedCategoryBookMapper
import com.example.data.data.category.categoryBooks.data.repository.CategoryBooksRepositoryImp
import com.example.data.data.category.categoryBooks.data.store.CategoryBooksLocalDataSource
import com.example.data.data.category.categoryBooks.data.store.CategoryBooksNetworkDataSource
import com.example.data.data.category.categoryBooks.remote.mapper.CategoryBookResponseModelMapper
import com.example.data.data.category.remote.service.CategoryServices
import com.example.domain.feature.books.feature.category.categorybooks.repository.CategoryBooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CategoryBookRepositoryModule {
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
    fun provideCatBookBookMapper(): CategoryBookResponseModelMapper {
        return CategoryBookResponseModelMapper
    }
    @Provides
    fun provideBookCategoryRepository(
        networkDataSource: CategoryBooksNetworkDataSource,
        localDataSource: CategoryBooksLocalDataSource,
        mapperRemote: CategoryBookResponseModelMapper,
        mapperCached: CachedCategoryBookMapper
    ): CategoryBooksRepository {
        return CategoryBooksRepositoryImp(networkDataSource, localDataSource, mapperRemote, mapperCached)
    }
}