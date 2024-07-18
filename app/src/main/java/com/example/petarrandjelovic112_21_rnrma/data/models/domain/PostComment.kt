package com.example.petarrandjelovic112_21_rnrma.data.models.domain

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostComment(
    val postId: String,
    val id: String,
    val name: String,
    val email: String,
    val body: String
)
