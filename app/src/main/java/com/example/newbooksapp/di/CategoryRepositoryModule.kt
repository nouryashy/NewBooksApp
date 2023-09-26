package com.example.newbooksapp.di

import com.example.data.data.category.categoryBooks.data.repository.CategoryRepositoryImp
import com.example.domain.feature.books.feature.category.categorybooks.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CategoryRepositoryModule {
    @Provides
    fun provideCategoryRepository(): CategoryRepository { return CategoryRepositoryImp() }
}