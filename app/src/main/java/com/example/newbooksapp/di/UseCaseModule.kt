package com.example.postsappdemo.di


import com.example.domain.feature.books.repository.BooksRepository
import com.example.domain.feature.books.usecase.GetBooks
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(booksRepository: BooksRepository): GetBooks {
        return GetBooks(booksRepository)
    }
}