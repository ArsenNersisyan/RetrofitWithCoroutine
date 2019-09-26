package com.arsen_nersisyan.retrofitwithcoroutine.model

data class TmdbMovie(
    val id: Int,
    val vote_average: Double,
    val title: String,
    val overview: String,
    val backdrop_path: String,
    val adult: Boolean
)

data class TmdbMovieResponse(
    val results: Array<TmdbMovie>
)