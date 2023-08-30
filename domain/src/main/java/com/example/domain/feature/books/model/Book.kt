package com.example.domain.feature.books.model

import androidx.room.Entity
import androidx.room.PrimaryKey
data class Book(
    val id: Int,
    val authors: List<Author>,
    val bookshelves: List<String>,
    val copyright: Boolean,
    val download_count: Int,
    val formats: Formats,
    val languages: List<String>,
    val media_type: String,
    val subjects: List<String>,
    val title: String,
    val translators: List<Translator>
)