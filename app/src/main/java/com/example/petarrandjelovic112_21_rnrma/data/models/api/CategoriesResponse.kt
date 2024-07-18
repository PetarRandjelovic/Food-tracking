package com.example.petarrandjelovic112_21_rnrma.data.models.api

import com.squareup.moshi.JsonClass
import java.util.Locale.Category

@JsonClass(generateAdapter = true)
data class CategoriesResponse(
    val categories:List<CategoryResponse>

)
