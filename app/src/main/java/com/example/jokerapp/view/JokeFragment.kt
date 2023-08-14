package com.example.jokerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.jokerapp.R
import com.example.jokerapp.model.Joke
import com.example.jokerapp.presentation.JokePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class JokeFragment : Fragment() {

    private lateinit var txtJoke: TextView
    private lateinit var iconJoke: ImageView
    private lateinit var progressBar: ProgressBar

    private var presenter = JokePresenter(this)

    companion object {
        const val CATEGORY_KEY_NAME = "categoryName"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryName = arguments?.getString(CATEGORY_KEY_NAME)
        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = categoryName!!.replaceFirstChar { it.uppercase() }

        progressBar = view.findViewById(R.id.progressBar)
        txtJoke = view.findViewById(R.id.txt_joke)
        iconJoke = view.findViewById(R.id.img_logo)

        presenter.findBy(categoryName)

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            presenter.findBy(categoryName)
        }
    }

    fun showJoke(joke: Joke){
        txtJoke.text = joke.txtJoke
        Picasso.get().load(joke.iconUrl).into(iconJoke)
    }

    fun showError(message: String){
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