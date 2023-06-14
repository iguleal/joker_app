package com.example.jokerapp.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {

  fun findAllCategories(callback: ListCategoryCallback) {
    HTTPClient.retrofit()
      .create(ChuckNorrisAPI::class.java)
      .findAllCategories()
      .enqueue(object : Callback<List<String>> {

        override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
          if (response.isSuccessful) {
            val categories = response.body()
            callback.onSuccess(categories ?: emptyList())
          } else {
            val error = response.errorBody()?.toString()
            callback.onFailure(error ?: "Erro desconhecido")
          }

        }

        override fun onFailure(call: Call<List<String>>, t: Throwable) {
          callback.onFailure(t.message ?: "Erro interno")
        }

      })
  }
}