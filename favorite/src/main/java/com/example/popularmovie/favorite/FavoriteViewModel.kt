package com.example.popularmovie.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.popularmovie.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoritePopularMovie = movieUseCase.getFavoritePopularMovie().asLiveData()
}