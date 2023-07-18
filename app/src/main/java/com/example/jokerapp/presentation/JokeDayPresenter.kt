package com.example.jokerapp.presentation

import com.example.jokerapp.data.JokeCallback
import com.example.jokerapp.data.JokeDayRemoteDataSource
import com.example.jokerapp.model.Joke
import com.example.jokerapp.view.JokeDayFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
) : JokeCallback {

    fun findJoke() {
        view.visibilityProgressBar(true)
        dataSource.findJoke(this)
    }

    override fun onSuccess(response: Joke) {
        view.visibilityProgressBar(false)
        view.showJoke(response)
    }

    override fun onFailure(message: String) {
        view.visibilityProgressBar(false)
        view.showError(message)
    }
}