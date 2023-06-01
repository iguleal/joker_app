package com.example.jokerapp.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.jokerapp.R
import com.example.jokerapp.model.Category
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem(private val category: Category) : Item<CategoryItem.CategoryViewHolder>() {

    override fun getLayout() = R.layout.item_category

    override fun createViewHolder(itemView: View) = CategoryViewHolder(itemView)

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_category).text = category.name
        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category)
            .setBackgroundColor(category.bgColor.toInt())
    }

    class CategoryViewHolder(itemView: View) : GroupieViewHolder(itemView)
}