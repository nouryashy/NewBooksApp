package com.example.data.data.books.store

import com.example.data.data.books.remote.BooksServices
import com.example.domain.feature.books.feature.books.model.BooksResponse

class BookNetworkDataSource(val apiServices: BooksServices) {


        suspend fun getBooksFromApi(page:Int): BooksResponse
    = apiServices.getBooks(page)

//    suspend fun getBooksFromApi(url: String): Response<BooksResponce>
//    = apiServices.getBooks(url)

    }
