package com.mufeez.epasero.di

import android.content.Context
import androidx.annotation.OptIn
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.cache.CacheDataSource
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
import androidx.media3.datasource.DefaultHttpDataSource
import com.mufeez.epasero.data.repository.FeedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFeedRepository(): FeedRepository {
        return FeedRepository()
    }

    @OptIn(UnstableApi::class)
    @Provides
    @Singleton
    fun provideCacheDataSource(context: Context): CacheDataSource.Factory {
        val cacheDir = File(context.cacheDir, "exo_cache")
        val cache = SimpleCache(cacheDir, LeastRecentlyUsedCacheEvictor(100 * 1024 * 1024)) // 100MB cache

        return CacheDataSource.Factory()
            .setCache(cache)
            .setUpstreamDataSourceFactory(DefaultHttpDataSource.Factory())
            .setCacheWriteDataSinkFactory(null)
    }
}
