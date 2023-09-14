package com.example.newbooksapp.feature.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newbooksapp.R
import com.example.newbooksapp.databinding.FragmentBooksBinding
import com.example.newbooksapp.databinding.FragmentBooksDetBinding

class BooksDetFragment : Fragment() {
    private lateinit var fgDetBinding: FragmentBooksDetBinding
    var bookId: Int? = null
    var bookName: String? = null
    var bookImage: String? = null
    var bookDet: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fgDetBinding = FragmentBooksDetBinding.inflate(inflater, container, false)
        return fgDetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: BooksDetFragmentArgs by navArgs()
        bookId = args.bookId
        bookName = args.bookName
        bookImage = args.bookImg
        bookDet = args.bookDet

        fgDetBinding.bookNameTv.text = bookName
        fgDetBinding.bookDetTv.text = bookDet
        Glide.with(requireContext()).load(bookImage)
            .into(fgDetBinding.bookIv)

}


}