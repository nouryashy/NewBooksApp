package com.example.data.bookss.books.store

import com.example.data.bookss.books.remote.AuthorsServices
import com.example.data.data.authors.remote.model.AuthorsResponseModel

class AuthorNetworkDataSource(val apiServices: AuthorsServices) {
    suspend fun getAuthorsFromApi(): AuthorsResponseModel = apiServices.getAuthors()
}
