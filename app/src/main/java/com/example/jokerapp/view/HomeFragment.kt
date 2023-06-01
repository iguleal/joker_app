package com.example.jokerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jokerapp.R
import com.example.jokerapp.model.Category
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

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
        val adapter = GroupieAdapter()
        rv.adapter = adapter

        adapter.add(CategoryItem(Category("Categoria 1", 0xfffff222)))
        adapter.add(CategoryItem(Category("Categoria 2", 0xffcff338)))
        adapter.add(CategoryItem(Category("Categoria 3", 0xff9ef153)))
        adapter.add(CategoryItem(Category("Categoria 4", 0xff67ec6e)))

        adapter.notifyDataSetChanged()
    }
}