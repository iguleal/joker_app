package com.example.jokerapp.presentation

import android.os.Handler
import android.os.Looper
import com.example.jokerapp.model.Category
import com.example.jokerapp.view.CategoryItem
import com.example.jokerapp.view.HomeFragment

class HomePresenter(private val view: HomeFragment) {

    fun findAllCategories() {
        view.visibilityProgressBar(true)
        fakeRequest()
    }

    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                Category("Categoria 1", 0xfffff222),
                Category("Categoria 2", 0xffcff338),
                Category("Categoria 3", 0xff9ef153),
                Category("Categoria 4", 0xff67ec6e)
            )

            onSuccess(response)
//            onFailure("FALHA NA CONEXÃO")
            view.visibilityProgressBar(false)
        }, 2000)

    }

    private fun onFailure(message: String) {
        view.showError(message)
    }

    private fun onSuccess(response: List<Category>) {
        val categories = response.map { CategoryItem(it) }
        view.showCategories(categories)
    }
}