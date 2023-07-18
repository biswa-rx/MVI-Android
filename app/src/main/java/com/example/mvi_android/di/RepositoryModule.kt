package com.example.mvi_android.di

import com.example.mvi_android.remote.BlogAPI
import com.example.mvi_android.remote.NetworkMapper
import com.example.mvi_android.repository.MainRepository
import com.example.mvi_android.room.BlogDao
import com.example.mvi_android.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        blogAPI: BlogAPI,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(blogDao,blogAPI,cacheMapper,networkMapper)
    }
}