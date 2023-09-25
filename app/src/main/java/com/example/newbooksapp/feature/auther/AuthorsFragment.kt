package com.example.newbooksapp.feature.auther

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.domain.feature.books.books.model.Authors
import com.example.domain.feature.books.feature.books.model.Book
import com.example.newbooksapp.base.BaseAdapter
import com.example.newbooksapp.databinding.AuthorItemListBinding
import com.example.newbooksapp.databinding.BookItemListBinding
import com.example.newbooksapp.databinding.FragmentAuthorsBinding
import com.example.postsappdemo.state.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthorsFragment : Fragment() {
    private lateinit var authorsAdapter: BaseAdapter<Authors, AuthorItemListBinding>
    private lateinit var fgBinding: FragmentAuthorsBinding
    private val viewModel: AuthorsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fgBinding = FragmentAuthorsBinding.inflate(inflater, container, false)
        return fgBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAuthorsAdapter()
        fgBinding.authorRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = authorsAdapter
        }
        viewModel.getAuthors()
        observeAuthors()
    }
    @SuppressLint("SetTextI18n")
    private fun setUpAuthorsAdapter() {
        authorsAdapter =
            BaseAdapter(layoutInflater, AuthorItemListBinding::inflate) { binding, authors ->
                for (a in authors.authors) {
                    binding.authorNameTv.text = a.name
                    binding.authorBirthDateTv.text = "birth year ${a.birth_year}"
                    binding.authorDeathDateTv.text = "death year ${a.death_year}"
                }
            }
    }
    private fun observeAuthors() {
        lifecycleScope.launch {
            viewModel.authors.collect { result ->
                when (result) {
                    is Resource.Success -> {
                        val books = result.data
                        fgBinding.apply {
                            authorProgressBar.visibility = View.GONE
                        }
                        authorsAdapter.setItems(books)
                    }
                    is Resource.Loading -> {
                        fgBinding.apply {
                            authorProgressBar.visibility = View.VISIBLE
                        }
                    }
                    is Resource.Error -> {
                        val error = result.exception
                        fgBinding.apply {
                            authorProgressBar.visibility = View.GONE
                        }
                    }
                    else -> {}
                }
            }
        }
    }
}


