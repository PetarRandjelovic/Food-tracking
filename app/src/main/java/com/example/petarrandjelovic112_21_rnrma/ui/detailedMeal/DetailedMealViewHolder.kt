package com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petarrandjelovic112_21_rnrma.R

class DetailedMealViewHolder (itemView: View): ViewHolder(itemView) {

    val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    val imageViewMeal: ImageView = itemView.findViewById(R.id.imageViewMeal)
    val textViewCategory: TextView = itemView.findViewById(R.id.textViewCategory)
    val textViewInstructions: TextView = itemView.findViewById(R.id.textViewInstructions)
    val textViewURL: TextView = itemView.findViewById(R.id.textViewURL)
    val textViewArea: TextView = itemView.findViewById(R.id.textViewArea)
    val textViewTag: TextView = itemView.findViewById(R.id.textViewTag)
    val button: Button = itemView.findViewById(R.id.button)
}