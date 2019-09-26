package com.arsen_nersisyan.retrofitwithcoroutine.view_model.base

/**
 * Created by Arsen Nersisyan
 */
interface BindableAdapter<T> {
    fun setData(items: List<T>?)
}