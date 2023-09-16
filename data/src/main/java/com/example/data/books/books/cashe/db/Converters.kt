package com.example.data.books.books.cashe.db

import androidx.room.TypeConverter
import com.example.domain.feature.books.feature.books.model.Book
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    private val gson = Gson()
    @TypeConverter
    fun fromFormats(formats: Book.Formats): String {
        return formats.imageJPEG
    }

    @TypeConverter
    fun toFormats(image: String): Book.Formats {
        return Book.Formats(image)
    }

        @TypeConverter
    fun fromBookSubjectList(subject: List<String>): String {
        return gson.toJson(subject)
    }

    @TypeConverter
    fun toBookSubjectList(subjectString: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(subjectString, listType)
    }
}