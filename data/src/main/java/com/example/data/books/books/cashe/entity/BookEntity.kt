package com.example.data.books.books.cashe.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.feature.books.feature.books.model.Formats

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
//    val authors: List<Author>,
//    val bookshelves: List<String>,
//    val copyright: Boolean,
//    val download_count: Int,
    val formats: Formats,
//    val languages: List<String>,
//    val media_type: String,
    val subjects: List<String>,
    val title: String,
//    val translators: List<Translator>
)