package com.example.popularmovie.di

import com.example.popularmovie.core.domain.usecase.MovieInteractor
import com.example.popularmovie.core.domain.usecase.MovieUseCase
import com.example.popularmovie.detail.DetailViewModel
import com.example.popularmovie.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import javax.inject.Singleton

/*
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor) : MovieUseCase

}*/

val useCaseModule = module {
    factory<MovieUseCase> {
        MovieInteractor(get())
    }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}