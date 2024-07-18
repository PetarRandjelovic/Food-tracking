package com.example.petarrandjelovic112_21_rnrma.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryResponse(
    val idCategory: Int?=null,
    val strCategory: String?=null,
    val strCategoryThumb: String?=null,
    val strCategoryDescription: String?=null,

)
