package com.example.domain.feature.books.feature.books.model

import androidx.room.Entity
import androidx.room.PrimaryKey
data class Book(
    val id: Int,
//    val authors: List<Author>,
    val formats: Formats,
    val subjects: List<String>,
    val title: String,

)