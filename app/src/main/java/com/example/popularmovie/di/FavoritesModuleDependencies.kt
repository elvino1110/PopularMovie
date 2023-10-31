package com.example.popularmovie.di

import com.example.popularmovie.core.domain.usecase.MovieUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoritesModuleDependencies {

    fun movieUseCase(): MovieUseCase
}