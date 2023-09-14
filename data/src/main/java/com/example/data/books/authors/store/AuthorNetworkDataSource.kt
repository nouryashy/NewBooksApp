package com.example.data.bookss.books.store

import com.example.data.bookss.books.remote.AuthorsServices
import com.example.domain.feature.books.books.model.Authors
import com.example.domain.feature.books.books.model.AuthorsResponce
import com.example.domain.feature.books.feature.books.model.Author
import com.example.domain.feature.books.feature.books.model.BooksResponce

class AuthorNetworkDataSource(val apiServices: AuthorsServices) {


    suspend fun getAuthorsFromApi(): AuthorsResponce = apiServices.getAuthors()

}
