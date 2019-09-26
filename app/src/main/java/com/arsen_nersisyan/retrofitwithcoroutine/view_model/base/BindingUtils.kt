package com.arsen_nersisyan.retrofitwithcoroutine.view_model.base

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arsen_nersisyan.retrofitwithcoroutine.AppConstants
import com.squareup.picasso.Picasso

/**
 * Created by Arsen Nersisyan
 */
@BindingAdapter("recyclerData")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, items: List<T>?) {
    if (recyclerView.adapter is BindableAdapter<*>) {
        (recyclerView.adapter as BindableAdapter<T>).setData(items)
    }
}

@BindingAdapter("recyclerAdapter")
fun setRecyclerAdapter(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<*>
) {
    recyclerView.adapter = adapter
}

@BindingAdapter("visibleIf")
fun visibleIf(anyView: View, show: Boolean) {
    anyView.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("imageurl")
fun loadImage(imv: AppCompatImageView, imgUrl: String?) {
    imgUrl?.let {
        val finalUrl = AppConstants.TMDB_BACKDROP_IMAGE_URL + it
        Picasso.get().load(finalUrl).into(imv)
    }
}