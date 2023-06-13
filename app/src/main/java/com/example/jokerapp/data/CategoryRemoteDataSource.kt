package com.example.jokerapp.data

import android.os.Handler
import android.os.Looper
import com.example.jokerapp.model.Category
import com.example.jokerapp.view.HomeFragment

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback ){
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                Category("Categoria 1", 0xfffff222),
                Category("Categoria 2", 0xffcff338),
                Category("Categoria 3", 0xff9ef153),
                Category("Categoria 4", 0xff67ec6e)
            )

            callback.onSuccess(response)
//            onFailure("FALHA NA CONEXÃO")
        }, 2000)
    }
}