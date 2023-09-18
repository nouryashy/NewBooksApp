package com.example.data.bookss.books.store

import com.example.data.bookss.books.remote.CategoryServices
import com.example.domain.feature.books.books.model.AuthorsResponse

class AuthorNetworkDataSource(val apiServices: CategoryServices) {


    suspend fun getAuthorsFromApi(): AuthorsResponse = apiServices.getAuthors()

}
