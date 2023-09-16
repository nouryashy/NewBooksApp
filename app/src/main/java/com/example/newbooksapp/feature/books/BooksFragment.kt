package com.example.newbooksapp.feature.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.feature.books.feature.books.model.Book
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
        booksAdapter = BooksAdapter(onClicked)
        fgBinding.booksRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = booksAdapter
        }
        viewModel.loadBooks()
        observeBooksState()
        setRecyOnScrollListner()
    }

    private fun setRecyOnScrollListner() {
        fgBinding.booksRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                val totalItemCount = layoutManager.itemCount
                if (lastVisibleItemPosition + 1 == totalItemCount) {
                    viewModel.loadNextPage()
                }
            }
        })
    }


    private val onClicked = object : BooksAdapter.OnItemClickListener {
        override fun onClicked(book: Book) {
        val bookId = book.id
        val bookTitle = book.title
        val bookImg = book.formats.imageJPEG
        val bookDet = book.subjects[0]
        val action = BooksFragmentDirections.actionBooksFragmentToBooksDetFragment(
            bookId, bookTitle, bookImg, bookDet
        )
        findNavController().navigate(action)

        }
    }



private fun observeBooksState() {
    lifecycleScope.launch {
        viewModel.books.collect { result ->
            when (result) {

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

                is Resource.Loading -> {
                    // Show loading UI
                    fgBinding.apply {
                        progressBar.visibility = View.VISIBLE
                        booksRv.visibility = View.GONE
                        tvError.visibility = View.GONE
                    }
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
}}




