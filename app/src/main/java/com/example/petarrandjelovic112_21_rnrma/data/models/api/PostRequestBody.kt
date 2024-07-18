package com.example.petarrandjelovic112_21_rnrma.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostRequestBody(
    val userId: String,
    val title: String,
    val body: String
)
