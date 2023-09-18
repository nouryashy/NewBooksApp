package com.example.domain.feature.books.feature.category.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("next")
    val next: String,
    @SerializedName("results")
    val categories: List<Category>
)