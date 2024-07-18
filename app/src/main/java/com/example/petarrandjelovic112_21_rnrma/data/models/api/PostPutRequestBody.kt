package com.example.petarrandjelovic112_21_rnrma.data.models.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostPutRequestBody(
    val userId: String,
    val id: String,
    val title: String,
    val body: String
)
