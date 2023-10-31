package com.example.popularmovie.detail

import androidx.lifecycle.ViewModel
import com.example.popularmovie.core.domain.model.Movie
import com.example.popularmovie.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    fun setFavoritePopularMovie(movie: Movie, newState: Boolean) =
        movieUseCase.setFavoritePopularMovie(movie, newState)
}