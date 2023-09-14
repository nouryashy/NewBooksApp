package com.example.newbooksapp.di

import com.example.data.books.books.cashe.mapper.BookMapper
import com.example.data.books.books.remote.BooksServices
import com.example.data.books.books.repository.BooksRepositoryImp
import com.example.data.books.books.store.BookLocalDataSourse
import com.example.data.books.books.store.BookNetworkDataSource
import com.example.data.bookss.books.remote.AuthorsServices
import com.example.data.bookss.books.repository.AuthorsRepositoryImp
import com.example.data.bookss.books.store.AuthorNetworkDataSource
import com.example.domain.feature.books.books.repository.AuthorRepository
import com.example.domain.feature.books.feature.books.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthorRepositoryModule {

    @Provides
    fun provideAuthorNetworkDataSource(apiService: AuthorsServices): AuthorNetworkDataSource {
        return AuthorNetworkDataSource(apiService)
    }
    @Provides
    fun provideAuthorRepository(
        networkDataSource: AuthorNetworkDataSource,
    ): AuthorRepository {
        return AuthorsRepositoryImp(networkDataSource)
    }
}