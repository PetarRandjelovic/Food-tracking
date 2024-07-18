package com.example.petarrandjelovic112_21_rnrma.data.models.api

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class IngredientResponse(
    val idIngredient: Int?=null,
    val strIngredient: String?=null,
    val strDescription: String?=null,
    val strType: String?=null,

    )