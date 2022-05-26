package com.test.mvvmretrofit.repository

import com.test.mvvmretrofit.Movie
import retrofit2.Response

interface MainRepository {
    suspend fun getAllMovies() : Response<List<Movie>>
}