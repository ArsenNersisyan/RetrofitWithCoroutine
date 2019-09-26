package com.arsen_nersisyan.retrofitwithcoroutine.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arsen_nersisyan.retrofitwithcoroutine.R
import com.arsen_nersisyan.retrofitwithcoroutine.databinding.MainResItemLayuotBinding
import com.arsen_nersisyan.retrofitwithcoroutine.model.TmdbMovie
import com.arsen_nersisyan.retrofitwithcoroutine.view_model.base.BindableAdapter

/**
 * Created by Arsen Nersisyan
 */
class MainRecAdapter : RecyclerView.Adapter<MainViewHolder>(),
    BindableAdapter<TmdbMovie> {

    private val dataList: MutableList<TmdbMovie> = ArrayList()

    override fun setData(items: List<TmdbMovie>?) {
        dataList.clear()
        items?.let {
            dataList.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val recItemBinding = DataBindingUtil.inflate<MainResItemLayuotBinding>(
            LayoutInflater.from(parent.context),
            R.layout.main_res_item_layuot, parent, false
        )
        return MainViewHolder(recItemBinding)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.movie = dataList[position]
    }
}

class MainViewHolder(val binding: MainResItemLayuotBinding) : RecyclerView.ViewHolder(binding.root)