package com.example.jokerapp.data

import com.example.jokerapp.model.Category


interface ListCategoryCallback {

    fun onSuccess(response: List<Category>)

    fun onFailure(message: String)
}