package com.example.domain.feature.books.model

import com.google.gson.annotations.SerializedName

data class BooksResponce(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val books: List<Book>
)