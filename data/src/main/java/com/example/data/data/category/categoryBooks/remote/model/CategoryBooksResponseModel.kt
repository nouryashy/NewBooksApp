package com.example.data.data.category.categoryBooks.remote.model
import com.google.gson.annotations.SerializedName

data class CategoryBooksResponseModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val categoryBooks: List<CategoryBookModel>
)