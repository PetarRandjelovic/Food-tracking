package com.example.petarrandjelovic112_21_rnrma.ui.category

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petarrandjelovic112_21_rnrma.R

class CategoryViewHolder(ItemView: View)  : RecyclerView.ViewHolder(ItemView){

    val nameCategory: TextView = itemView.findViewById(R.id.nameCategory)
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
    val imageButton: ImageButton = itemView.findViewById(R.id.imageButtonDetail)





}