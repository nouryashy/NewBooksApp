package com.example.data.data.category.remote.model
import com.google.gson.annotations.SerializedName

data class CategoryBooksResponseModel(
    @SerializedName("results")
    val categoryBooks: List<CategoryBookModel>
)