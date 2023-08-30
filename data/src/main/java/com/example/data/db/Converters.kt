package com.example.data.db

import androidx.room.TypeConverter
import com.example.domain.feature.books.model.Author
import com.example.domain.feature.books.model.Formats
import com.example.domain.feature.books.model.Translator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    private val gson = Gson()
    @TypeConverter
    fun fromFormats(formats: Formats): String {
        return formats.imageJPEG
    }

    @TypeConverter
    fun toFormats(image: String): Formats {
        return Formats(image)
    }

    @TypeConverter
    fun fromAuthorsList(authors: List<Author>): String {
        return gson.toJson(authors)
    }

    @TypeConverter
    fun toAuthorsList(authorsString: String): List<Author> {
        val listType = object : TypeToken<List<Author>>() {}.type
        return gson.fromJson(authorsString, listType)
    }

    @TypeConverter
    fun fromTranslatorsList(translators: List<Translator>): String {
        return gson.toJson(translators)
    }

    @TypeConverter
    fun toTranslatorsList(translatorsString: String): List<Translator> {
        val listType = object : TypeToken<List<Translator>>() {}.type
        return gson.fromJson(translatorsString, listType)
    }


    @TypeConverter
    fun fromBookshelvesList(bookshelves: List<String>): String {
        return gson.toJson(bookshelves)
    }

    @TypeConverter
    fun toBookshelvesList(bookshelvesString: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(bookshelvesString, listType)
    }


}