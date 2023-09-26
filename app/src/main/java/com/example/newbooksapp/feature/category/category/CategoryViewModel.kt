package com.example.newbooksapp.feature.category.category

import androidx.lifecycle.ViewModel
import com.example.domain.feature.books.feature.category.categorybooks.usecase.GetCategoriesLable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoryLabelUseCase: GetCategoriesLable

) : ViewModel() {

    fun getCategoriesLable() = getCategoryLabelUseCase.execute()

}