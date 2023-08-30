package com.example.newbooksapp.feature.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newbooksapp.databinding.FragmentBooksBinding
import com.example.postsappdemo.state.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BooksFragment : Fragment() {

    var booksAdapter: BooksAdapter? = null
    private lateinit var fgBinding: FragmentBooksBinding
    private val viewModel: BooksViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fgBinding = FragmentBooksBinding.inflate(inflater, container, false)
        return fgBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fgBinding.booksRv
        booksAdapter = BooksAdapter()
        viewModel.getBooks()
        observeBooksState()
        fgBinding.booksRv.adapter = booksAdapter
    }

    private fun observeBooksState() {
        lifecycleScope.launch {
            viewModel.booksState.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        // Show loading UI
                        fgBinding.apply {
                            progressBar.visibility = View.VISIBLE
                            booksRv.visibility = View.GONE
                            tvError.visibility = View.GONE
                        }
                    }
                    is Resource.Success -> {
                        val books = result.data
                        // Update RecyclerView with the list of books
                        fgBinding.apply {
                            progressBar.visibility = View.GONE
                            booksRv.visibility = View.VISIBLE
                            tvError.visibility = View.GONE
                        }
                        booksAdapter!!.submitList(books)


                    }
                    is Resource.Error -> {
                        val error = result.exception
                        // Show error UI
                        fgBinding.tvError.visibility = View.VISIBLE
                    }
                    else -> {}
                }
            }
        }
    }

}


