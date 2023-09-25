package com.example.data.data.books.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class CachedBook(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val formats: FormatsCached,
    val subjects: List<String>,
    val title: String,
)
{
    data class FormatsCached (
        val imageJPEG: String,
    )

}
