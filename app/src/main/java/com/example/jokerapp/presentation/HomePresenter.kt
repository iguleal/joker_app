package com.example.jokerapp.presentation

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
        val categories = response.map { CategoryItem(Category(it, 0xFFFF0000)) }
        view.showCategories(categories)
        view.visibilityProgressBar(false)
    }

    override fun onFailure(message: String) {
        view.showError(message)
        view.visibilityProgressBar(false)
    }
}