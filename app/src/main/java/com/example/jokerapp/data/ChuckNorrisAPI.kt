package com.example.jokerapp.data

import retrofit2.Call
import retrofit2.http.GET

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun findAllCategories():Call<List<String>>
}