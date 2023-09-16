package com.example.data.bookss.books.store

import com.example.data.bookss.books.remote.AuthorsServices
import com.example.domain.feature.books.books.model.AuthorsResponce

class AuthorNetworkDataSource(val apiServices: AuthorsServices) {


    suspend fun getAuthorsFromApi(): AuthorsResponce = apiServices.getAuthors()

}
