package com.example.data.data.category.cache.db

import androidx.room.TypeConverter
import com.example.data.data.books.cache.entity.CachedBook
import com.example.data.data.category.cache.entity.CachedCategoryBook
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryBooksConverters {
    private val gson = Gson()
    @TypeConverter
    fun fromFormats(formats: CachedCategoryBook.CachedFormatsCat): String {
        return formats.imageJPEG
    }

    @TypeConverter
    fun toFormats(image: String): CachedCategoryBook.CachedFormatsCat {
        return CachedCategoryBook.CachedFormatsCat(image)
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