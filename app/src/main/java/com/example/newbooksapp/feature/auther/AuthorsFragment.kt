package com.example.newbooksapp.feature.auther

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newbooksapp.databinding.FragmentAuthorsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthorsFragment : Fragment() {
    var authorsAdapter: AuthorsAdapter? = null

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
        authorsAdapter = AuthorsAdapter()
        fgBinding.authorRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = authorsAdapter
        }
        observeAuthors()
        viewModel.getAuthors()
    }

    private fun observeAuthors() {
        lifecycleScope.launch {
            viewModel.authors.collect {
                authorsAdapter!!.submitList(it)

            }
        }
    }
}


