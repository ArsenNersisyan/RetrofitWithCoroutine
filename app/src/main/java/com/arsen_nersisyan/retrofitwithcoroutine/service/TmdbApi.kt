package com.arsen_nersisyan.retrofitwithcoroutine.service

import com.arsen_nersisyan.retrofitwithcoroutine.model.TmdbMovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface TmdbApi {

    @GET("movie/popular")
    suspend fun getPopularMovie(): Response<TmdbMovieResponse>
}