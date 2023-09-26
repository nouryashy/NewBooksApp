package com.example.newbooksapp.feature.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.feature.books.feature.books.model.Book
import com.example.domain.feature.books.feature.category.model.CategoryBook
import com.example.domain.feature.books.feature.category.usecase.GetBooksAccordingToCategories
import com.example.domain.feature.books.feature.category.usecase.GetCategoriesLable
import com.example.postsappdemo.state.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoryLabelUseCase: GetCategoriesLable,
    private val getCategoryBooksUseCase: GetBooksAccordingToCategories,
    ) : ViewModel() {
    private var _catBooks = MutableStateFlow<Resource<List<CategoryBook>>>(Resource.Loading)
    val catBook: StateFlow<Resource<List<CategoryBook>>> = _catBooks

    fun getCategoriesLable() = getCategoryLabelUseCase.execute()


    fun loadBooksAccordingToCategory(topic: String) {
        _catBooks.value = Resource.Loading
        viewModelScope.launch {
            try {
                val bookList = getCategoryBooksUseCase(topic)
                _catBooks.value = Resource.Success(bookList)
            } catch (e: Exception) {
                _catBooks.value = Resource.Error(e)
            }
        }
    }
}