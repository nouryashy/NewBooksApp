package com.example.newbooksapp.feature.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.feature.books.feature.category.model.CategoryLabel
import com.example.newbooksapp.base.BaseAdapter
import com.example.newbooksapp.databinding.CategoryItemListBinding
import com.example.newbooksapp.databinding.FragmentCategoryBinding
import com.example.postsappdemo.state.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryFragment : Fragment() {
    private lateinit var categoryAdapter: BaseAdapter<CategoryLabel, CategoryItemListBinding>
    private lateinit var fgBinding: FragmentCategoryBinding
    private val viewModel: CategoryViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fgBinding = FragmentCategoryBinding.inflate(inflater, container, false)
        return fgBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCategoryAdapter()
        fgBinding.categoryRv.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = categoryAdapter
        }
        val categoriesLabel = viewModel.getCategoriesLable()
        categoryAdapter.setItems(categoriesLabel)
    }

    private fun setUpCategoryAdapter() {
        categoryAdapter =
            BaseAdapter(layoutInflater, CategoryItemListBinding::inflate) { binding, category ->
                binding.categoryNameTv.text = category.name
            }
        categoryAdapter.setOnItemClickListener { category ->
            val categoryId = category.id
            val categoryName = category.name
            val action = CategoryFragmentDirections
                .actionCategoryFragmentToCategoryDetFragment(
                    categoryId,
                    categoryName)
            findNavController().navigate(action)
        }
    }
}