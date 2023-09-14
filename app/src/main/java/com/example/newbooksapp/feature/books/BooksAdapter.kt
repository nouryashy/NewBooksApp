package com.example.newbooksapp.feature.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.feature.books.feature.books.model.Book

import com.example.newbooksapp.databinding.BookItemListBinding


class BooksAdapter(
    var listener: OnItemClickListener
) :
    androidx.recyclerview.widget.ListAdapter<Book, BooksAdapter.ViewHolder>(
        BookDiffCallback()
    ) {

    interface OnItemClickListener {
        fun onClicked(book: Book)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            BookItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    fun setClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(private val itemBinding: BookItemListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(book: Book) {
            itemBinding.booksNameTv.text = book.title
            itemBinding.booksDesTv.text = book.subjects[0]
            Glide.with(itemBinding.root.context).load(book.formats.imageJPEG)
                .into(itemBinding.booksIv)

            itemBinding.root.setOnClickListener {
                listener.onClicked(book)
            }
        }

    }

    class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(
            oldItem: Book,
            newItem: Book
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Book,
            newItem: Book
        ): Boolean {
            return oldItem == newItem
        }
    }
}

