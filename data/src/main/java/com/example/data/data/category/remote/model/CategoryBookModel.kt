package com.example.data.data.category.remote.model


data class CategoryBookModel(
    val id: Int,
    val formats: FormatsCatModel,
    val subjects: List<String>,
    val title: String,

    )
{
    data class FormatsCatModel (
        val imageJPEG: String,
    )
}