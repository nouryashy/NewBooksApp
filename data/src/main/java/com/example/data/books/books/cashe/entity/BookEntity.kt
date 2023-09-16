package com.example.data.books.books.cashe.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.feature.books.feature.books.model.Book

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val formats: Book.Formats,
    val subjects: List<String>,
    val title: String,
)