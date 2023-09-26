package com.example.domain.feature.books.feature.category.model


data class CategoryBook(
    val id: Int,
    val formats: FormatsCat,
    val subjects: List<String>,
    val title: String,

    )
{
    data class FormatsCat (
        val imageJPEG: String,
    )
}