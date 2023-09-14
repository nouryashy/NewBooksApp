package com.example.domain.feature.books.books.model

import com.google.gson.annotations.SerializedName

data class AuthorsResponce(

    @SerializedName("results")
    val authors: List<Authors>
)