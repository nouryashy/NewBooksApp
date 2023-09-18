package com.example.postsappdemo.di

import com.example.domain.feature.books.books.repository.AuthorRepository
import com.example.domain.feature.books.feature.authors.usecase.GetAuthors
import com.example.domain.feature.books.feature.books.repository.BooksRepository
import com.example.domain.feature.books.feature.books.usecase.GetBooks
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideBookUseCase(booksRepository: BooksRepository): GetBooks {
        return GetBooks(booksRepository)
    }


    @Provides
    fun provideAuthorUseCase(authorRepository: AuthorRepository): GetAuthors {
        return GetAuthors(authorRepository)
    }


}