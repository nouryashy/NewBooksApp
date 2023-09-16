package com.example.domain.feature.books.feature.books.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Book(
    val id: Int,
    val formats: Formats,
    val subjects: List<String>,
    val title: String,

)
{
    data class Formats (
        @SerializedName("image/jpeg")
        val imageJPEG: String,
    )
}