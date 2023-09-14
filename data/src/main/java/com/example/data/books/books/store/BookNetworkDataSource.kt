package com.example.data.books.books.store

import com.example.data.books.books.remote.BooksServices
import com.example.domain.feature.books.feature.books.model.BooksResponce

class BookNetworkDataSource(val apiServices: BooksServices) {


        suspend fun getBooksFromApi(page:Int): BooksResponce
    = apiServices.getBooks(page)

//    suspend fun getBooksFromApi(url: String): Response<BooksResponce>
//    = apiServices.getBooks(url)

    }
