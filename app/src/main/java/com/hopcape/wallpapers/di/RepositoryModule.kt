package com.hopcape.wallpapers.di

import com.hopcape.wallpapers.data.repo.FirebaseCatalogsRepositoryImpl
import com.hopcape.wallpapers.data.repo.FirebaseWallpapersRepositoryImpl
import com.hopcape.wallpapers.domain.repo.ICatalogRepository
import com.hopcape.wallpapers.domain.repo.IWallpapersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Provide Repository Implementation Here*/
    @Provides
    @Singleton
    fun providesWallapapersRepository(): IWallpapersRepository{
        return FirebaseWallpapersRepositoryImpl()
    }

    /**
     * Provide Catalog Repository*/
    @Provides
    @Singleton
    fun providesCatalogRepository(): ICatalogRepository {
        return FirebaseCatalogsRepositoryImpl()
    }
}