package com.arsen_nersisyan.retrofitwithcoroutine.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arsen_nersisyan.retrofitwithcoroutine.model.TmdbMovie
import com.arsen_nersisyan.retrofitwithcoroutine.repository.MovieRepository
import com.arsen_nersisyan.retrofitwithcoroutine.service.ApiFactory
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

/**
 * Created by Arsen Nersisyan
 */
class TmdbViewModel : ViewModel() {

    val errorHandler = CoroutineExceptionHandler { _, exception ->
        // Todo - handle exception properly
        println("Caught $exception with suppressed ${exception.suppressed.contentToString()}")
    }
    private val repository: MovieRepository = MovieRepository(ApiFactory.tmdbApi)

    val popularMoviesLiveData = MutableLiveData<MutableList<TmdbMovie>>()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    fun fetchMovies() {
        isLoading.postValue(true)
        viewModelScope.plus(errorHandler).launch {
            val popularMovies = repository.getPopularMovies()
            popularMoviesLiveData.postValue(popularMovies)
            isLoading.postValue(false)
        }
    }
}