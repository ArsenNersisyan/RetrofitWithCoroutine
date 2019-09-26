package com.arsen_nersisyan.retrofitwithcoroutine.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.arsen_nersisyan.retrofitwithcoroutine.R
import com.arsen_nersisyan.retrofitwithcoroutine.databinding.ActivityMainBinding
import com.arsen_nersisyan.retrofitwithcoroutine.view_model.TmdbViewModel

/**
 * Created by Arsen Nersisyan
 */

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TmdbViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[TmdbViewModel::class.java]
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            mainViewModel = viewModel
            recAdapter = MainRecAdapter()
        }
        viewModel.fetchMovies()
    }
}
