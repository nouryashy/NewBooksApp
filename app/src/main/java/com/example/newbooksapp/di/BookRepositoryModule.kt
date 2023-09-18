package com.example.postsappdemo.di


import com.example.data.data.books.cashe.mapper.BookMapper
import com.example.data.data.books.store.BookLocalDataSourse
import com.example.data.data.books.store.BookNetworkDataSource
import com.example.data.data.books.cashe.db.BooksDao
import com.example.data.data.books.remote.BooksServices
import com.example.data.data.books.repository.BooksRepositoryImp
import com.example.domain.feature.books.feature.books.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BookRepositoryModule {

    @Provides
    fun provideBookNetworkDataSource(apiService: BooksServices): BookNetworkDataSource {
        return BookNetworkDataSource(apiService)
    }

    @Provides
    fun provideBookLocalDataSource(dao: BooksDao): BookLocalDataSourse {
        return BookLocalDataSourse(dao)
    }

    @Provides
    fun provideBookBookMapper(): BookMapper {
        return BookMapper
    }

    @Provides
    fun provideBookRepository(
        networkDataSource: BookNetworkDataSource,
        localDataSourse: BookLocalDataSourse,
        mapper: BookMapper
    ): BooksRepository {
        return BooksRepositoryImp(networkDataSource, localDataSourse, mapper)
    }
}