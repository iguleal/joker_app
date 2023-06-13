package com.example.jokerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jokerapp.R
import com.example.jokerapp.model.Category
import com.example.jokerapp.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    private val presenter = HomePresenter(this)
    private val adapter = GroupieAdapter()
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        progressBar = view.findViewById(R.id.progressBar)
        presenter.findAllCategories()
    }

    fun showCategories(categories: List<CategoryItem>) {

//        val categories = mutableListOf<CategoryItem>()
//        for (category in response) {
//            categories.add(CategoryItem(category))
//        }
        adapter.addAll(categories)
        adapter.notifyDataSetChanged()
    }

    fun visibilityProgressBar(visibility: Boolean) {
        if (visibility) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    fun showError(message: String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }
}