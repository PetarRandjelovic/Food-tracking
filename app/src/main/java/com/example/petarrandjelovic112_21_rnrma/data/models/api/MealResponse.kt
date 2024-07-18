package com.example.petarrandjelovic112_21_rnrma.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealResponse(

    val strMeal: String?=null,
    val strMealThumb: String?=null,
    val idMeal: Int?=null,

    )