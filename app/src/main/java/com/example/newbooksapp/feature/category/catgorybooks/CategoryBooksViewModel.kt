package com.example.newbooksapp.feature.category.catgorybooks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.feature.books.feature.category.categorybooks.model.CategoryBook
import com.example.domain.feature.books.feature.category.categorybooks.usecase.GetBooksAccordingToCategories
import com.example.postsappdemo.state.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryBooksViewModel @Inject constructor(
    private val getCategoryBooksUseCase: GetBooksAccordingToCategories
) : ViewModel() {
    private var _catBooks = MutableStateFlow<Resource<List<CategoryBook>>>(Resource.Loading)
    val catBook: StateFlow<Resource<List<CategoryBook>>> = _catBooks


    fun loadBooksAccordingToCategory(topic: String) {
        _catBooks.value = Resource.Loading
        viewModelScope.launch {
            try {
                val categoryBookList = getCategoryBooksUseCase(topic)
                _catBooks.value = Resource.Success(categoryBookList)
            } catch (e: Exception) {
                _catBooks.value = Resource.Error(e)
            }
        }
    }
}
