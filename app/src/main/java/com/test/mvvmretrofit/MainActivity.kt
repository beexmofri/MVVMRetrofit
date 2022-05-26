package com.test.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.test.mvvmretrofit.adapter.MovieAdapter
import com.test.mvvmretrofit.databinding.ActivityMainBinding
import com.test.mvvmretrofit.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var movieAdapter: MovieAdapter
    private val viewModel : MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = movieAdapter

        viewModel.movieList.observe(this, Observer {
            movieAdapter.setMovies(it)
        })

        viewModel.progressBarStatus.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.fetchAllMovies()
    }
}
