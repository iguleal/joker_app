package com.example.jokerapp.data

import com.example.jokerapp.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class JokeRemoteDataSource {

    fun findBy(categoryName: String, callback: JokeCallback){
        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .findBy(categoryName)
            .enqueue(object : Callback<Joke>{
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if (response.isSuccessful) {
                        val joke = response.body()
                        callback.onSuccess(joke ?: throw Exception("Piada não encontrada"))
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onFailure(error ?: "Erro desconhecido")
                    }
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onFailure(t.message ?: "Erro interno")
                }

            })
    }





}