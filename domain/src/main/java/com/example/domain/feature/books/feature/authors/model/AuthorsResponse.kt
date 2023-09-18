package com.example.domain.feature.books.books.model

import com.google.gson.annotations.SerializedName

data class AuthorsResponse(

    @SerializedName("results")
    val authors: List<Authors>
)