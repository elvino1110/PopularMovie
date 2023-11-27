package com.example.popularmovie.core.di

import com.example.popularmovie.core.data.MovieRepository
import com.example.popularmovie.core.data.source.local.LocalDataSource
import com.example.popularmovie.core.data.source.remote.RemoteDataSource
import com.example.popularmovie.core.domain.repository.IMovieRepository
import com.example.popularmovie.core.utils.AppExecutors
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.koin.dsl.module

/*
@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IMovieRepository
}*/
val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMovieRepository> {
        MovieRepository(get(), get(), get())
    }
}