package com.example.petarrandjelovic112_21_rnrma.ui.mealDay

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.petarrandjelovic112_21_rnrma.R


class MealDayPageViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

    val name: TextView = itemView.findViewById(R.id.name)
    val imageView: ImageView = itemView.findViewById(R.id.imageView)

    val imageButton: ImageButton = itemView.findViewById(R.id.imageButtonDetail)



}