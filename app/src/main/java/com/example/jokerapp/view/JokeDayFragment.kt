package com.example.jokerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.jokerapp.R
import com.example.jokerapp.model.Joke
import com.example.jokerapp.presentation.JokeDayPresenter
import com.squareup.picasso.Picasso

class JokeDayFragment : Fragment() {

    private val presenter: JokeDayPresenter = JokeDayPresenter(this)

    private lateinit var progressBar: ProgressBar
    private lateinit var txtJoke: TextView
    private lateinit var iconJoke: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progressBar)
        txtJoke = view.findViewById(R.id.txt_joke_day)
        iconJoke = view.findViewById(R.id.img_logo)

        presenter.findJoke()

    }

    fun showJoke(joke:Joke) {
        txtJoke.text = joke.txtJoke
        Picasso.get().load(joke.iconUrl).into(iconJoke)
    }

    fun showError(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }

    fun visibilityProgressBar(visibility: Boolean) {
        if (visibility) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

}