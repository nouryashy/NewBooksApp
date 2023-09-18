package com.example.newbooksapp.di

import com.example.data.bookss.books.remote.CategoryServices
import com.example.data.bookss.books.repository.CategoriesRepositoryImp
import com.example.data.bookss.books.store.CategoryNetworkDataSource
import com.example.domain.feature.books.books.repository.AuthorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthorRepositoryModule {

    @Provides
    fun provideAuthorNetworkDataSource(apiService: CategoryServices): CategoryNetworkDataSource {
        return CategoryNetworkDataSource(apiService)
    }
    @Provides
    fun provideAuthorRepository(
        networkDataSource: CategoryNetworkDataSource,
    ): AuthorRepository {
        return CategoriesRepositoryImp(networkDataSource)
    }
}