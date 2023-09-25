package com.example.data.data.books.data.store

import com.example.data.data.books.remote.model.BooksResponseModel
import com.example.data.data.books.remote.service.BooksServices

class BookNetworkDataSource(val apiServices: BooksServices) {
    suspend fun getBooksFromApi(page: Int): BooksResponseModel = apiServices.getBooks(page)
}
