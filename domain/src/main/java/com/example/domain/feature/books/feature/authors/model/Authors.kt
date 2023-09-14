package com.example.domain.feature.books.books.model
data class Authors(
    val id: Int,
    val authors: List<Author>,
){
    data class Author(
        val id: Int,
        val birth_year: Int,
        val death_year: Int,
        val name: String
    )
}