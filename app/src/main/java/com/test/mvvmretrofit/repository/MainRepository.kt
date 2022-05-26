package com.test.mvvmretrofit.repository

import com.test.mvvmretrofit.retorfit.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}