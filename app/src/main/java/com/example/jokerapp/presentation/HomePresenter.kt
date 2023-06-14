package com.example.jokerapp.presentation

import android.graphics.Color
import com.example.jokerapp.data.CategoryRemoteDataSource
import com.example.jokerapp.data.ListCategoryCallback
import com.example.jokerapp.model.Category
import com.example.jokerapp.view.CategoryItem
import com.example.jokerapp.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.visibilityProgressBar(true)
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 190
        val diff = (end - start) / response.size

        val categories = response.mapIndexed { index, s ->

            val hsv = floatArrayOf(start + (index * diff).toFloat(), 1f, 1f)

            CategoryItem(Category(s, Color.HSVToColor(hsv).toLong()))
        }
        view.showCategories(categories)
        view.visibilityProgressBar(false)
    }

    override fun onFailure(message: String) {
        view.showError(message)
        view.visibilityProgressBar(false)
    }
}