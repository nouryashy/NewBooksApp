package com.example.domain.feature.books.feature.category.model

import com.google.gson.annotations.SerializedName

data class Category(
    val id: Int,
    val subjects: List<String>,
)
