package com.arsen_nersisyan.retrofitwithcoroutine.repository.base

/**
 * Created by Arsen Nersisyan
 */
sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}