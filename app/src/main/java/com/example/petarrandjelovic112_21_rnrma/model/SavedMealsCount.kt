package com.example.petarrandjelovic112_21_rnrma.model

import androidx.room.Entity
import androidx.room.PrimaryKey



data class SavedMealsCount(
    val formatted_date: String,
    val meals_count: Int
)