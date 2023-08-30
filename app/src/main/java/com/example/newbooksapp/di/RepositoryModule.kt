package com.example.postsappdemo.di



import com.example.data.mapper.BookMapper
import com.example.data.store.LocalDataSourse
import com.example.data.store.NetworkDataSource
import com.example.data.db.BooksDao
import com.example.data.remote.ApiServices
import com.example.data.repository.BooksRepositoryImp
import com.example.domain.feature.books.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideNetworkDataSource(apiService: ApiServices): NetworkDataSource {
        return NetworkDataSource(apiService)
    }

    @Provides
    fun provideLocalDataSource(dao:BooksDao): LocalDataSourse {
        return LocalDataSourse(dao)
    }

    @Provides
    fun provideBookMapper(): BookMapper {
        return BookMapper
    }

    @Provides
    fun provideRepository(
        networkDataSource: NetworkDataSource,
        localDataSourse: LocalDataSourse,
        mapper: BookMapper
    ): BooksRepository {
        return BooksRepositoryImp(networkDataSource, localDataSourse,mapper)
    }
}