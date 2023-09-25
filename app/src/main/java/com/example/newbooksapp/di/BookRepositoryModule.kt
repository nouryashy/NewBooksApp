package com.example.postsappdemo.di


import com.example.data.data.books.cache.db.BooksDao
import com.example.data.data.books.cache.mapper.CachedBookMapper
import com.example.data.data.books.data.repository.BooksRepositoryImp
import com.example.data.data.books.data.store.BookLocalDataSource
import com.example.data.data.books.data.store.BookNetworkDataSource
import com.example.data.data.books.remote.mapper.BookResponseModelMapper
import com.example.data.data.books.remote.service.BooksServices
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
    fun provideBookLocalDataSource(dao: BooksDao): BookLocalDataSource {
        return BookLocalDataSource(dao)
    }

    @Provides
    fun providecaChedBookMapper(): CachedBookMapper {
        return CachedBookMapper
    }


    @Provides
    fun provideBookBookMapper(): BookResponseModelMapper {
        return BookResponseModelMapper
    }


    @Provides
    fun provideBookRepository(
        networkDataSource: BookNetworkDataSource,
        localDataSourse: BookLocalDataSource,
        mapperRemote: BookResponseModelMapper,
        mapperCached: CachedBookMapper

    ): BooksRepository {
        return BooksRepositoryImp(networkDataSource, localDataSourse, mapperRemote, mapperCached)
    }
}