package com.arsen_nersisyan.retrofitwithcoroutine.service

import com.arsen_nersisyan.retrofitwithcoroutine.AppConstants

object ApiFactory {

    val tmdbApi: TmdbApi =
        RetrofitFactory.retrofit(AppConstants.TMDB_BASE_URL).create(TmdbApi::class.java)
}