package com.arsen_nersisyan.retrofitwithcoroutine.repository

import com.arsen_nersisyan.retrofitwithcoroutine.model.TmdbMovie
import com.arsen_nersisyan.retrofitwithcoroutine.repository.base.BaseRepository
import com.arsen_nersisyan.retrofitwithcoroutine.service.TmdbApi


/**
 * Created by Arsen Nersisyan
 */
class MovieRepository(private val api: TmdbApi) : BaseRepository() {

    suspend fun getPopularMovies(): MutableList<TmdbMovie>? {

        val movieResponse = safeApiCall(
            call = { api.getPopularMovie() },
            errorMessage = "Error Fetching Popular Movies"
        )

        return movieResponse?.results?.toMutableList()
    }
}