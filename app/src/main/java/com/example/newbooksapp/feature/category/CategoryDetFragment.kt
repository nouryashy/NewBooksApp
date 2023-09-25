package com.example.newbooksapp.feature.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.feature.books.feature.books.model.Book
import com.example.newbooksapp.R
import com.example.newbooksapp.base.BaseAdapter
import com.example.newbooksapp.databinding.BookItemListBinding
import com.example.newbooksapp.databinding.FragmentBooksDetBinding
import com.example.newbooksapp.databinding.FragmentCategoryDetBinding
import com.example.newbooksapp.feature.books.BooksDetFragmentArgs
import com.example.newbooksapp.feature.books.BooksFragmentDirections
import com.example.newbooksapp.feature.books.BooksViewModel
import com.example.postsappdemo.state.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryDetFragment : Fragment() {
    private var categoryId: Int? = null
    private var categoryName: String? = null
    private lateinit var fgDetBinding: FragmentCategoryDetBinding
    private lateinit var booksAdapter: BaseAdapter<Book, BookItemListBinding>
    private val viewModel: BooksViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fgDetBinding = FragmentCategoryDetBinding.inflate(inflater, container, false)
        return fgDetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: CategoryDetFragmentArgs by navArgs()
        categoryId = args.categoryId
        categoryName = args.categoryName
        setUpBookAdapter()
        fgDetBinding.categoriesBooksRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = booksAdapter
        }
        viewModel.loadBooks()
        observeBooksState()
        setRecyclerOnScrollListner()
    }

    private fun setUpBookAdapter() {
        booksAdapter = BaseAdapter(layoutInflater, BookItemListBinding::inflate) { binding, book ->
            binding.booksNameTv.text = book.title
            for (i in book.subjects) {
                binding.booksDesTv.text = i
            }
            Glide.with(binding.root.context).load(book.formats.imageJPEG)
                .into(binding.booksIv)
        }
        booksAdapter.setOnItemClickListener { book ->
            val bookId = book.id
            val bookTitle = book.title
            val bookImg = book.formats.imageJPEG
            var bookDet: String? = null
            for (i in book.subjects) {
                bookDet = i
            }
            val action = BooksFragmentDirections
                .actionBooksFragmentToBooksDetFragment(
                    bookId,
                    bookTitle,
                    bookImg,
                    bookDet!!
                )
            findNavController().navigate(action)
        }
    }

    private fun setRecyclerOnScrollListner() {
        fgDetBinding.categoriesBooksRv.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                val totalItemCount = layoutManager.itemCount
                if (lastVisibleItemPosition + 1 == totalItemCount) {
                    fgDetBinding.categoriesProgressBar.visibility = View.VISIBLE
                    viewModel.loadNextPage()
                }
            }
        })
    }

    private fun observeBooksState() {
        lifecycleScope.launch {
            viewModel.books.collect { result ->
                when (result) {
                    is Resource.Success -> {
                        val books = result.data
                        fgDetBinding.apply {
                            categoriesProgressBar.visibility = View.GONE
                        }
//                        booksAdapter.setItems(books)

                        val filteredList = ArrayList<Book>()
                        books.filterTo(filteredList) {
                            it.subjects.contains(categoryName)
                        }
                        booksAdapter.filter(filteredList)

                    }

                    is Resource.Loading -> {
                        fgDetBinding.apply {
                            categoriesProgressBar.visibility = View.VISIBLE
                        }
                    }

                    is Resource.Error -> {
                        val error = result.exception
                        fgDetBinding.apply {
                            categoriesProgressBar.visibility = View.GONE
                        }
                    }

                    else -> {}
                }
            }
        }
    }


}