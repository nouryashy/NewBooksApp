package com.example.newbooksapp.feature.auther

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.domain.feature.books.books.model.Authors

import com.example.newbooksapp.databinding.AuthorItemListBinding



class AuthorsAdapter(
) :
    androidx.recyclerview.widget.ListAdapter<Authors, AuthorsAdapter.ViewHolder>(
        BookDiffCallback()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            AuthorItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(private val itemBinding: AuthorItemListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(author: Authors) {


            for(a in author.authors){
                itemBinding.authorNameTv.text = a.name
                itemBinding.authorBirthDateTv.text = a.toString()
                itemBinding.authorDeathDateTv.text = a.toString()
            }

        }

    }

    class BookDiffCallback : DiffUtil.ItemCallback<Authors>() {
        override fun areItemsTheSame(
            oldItem: Authors,
            newItem: Authors
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Authors,
            newItem: Authors
        ): Boolean {
            return oldItem == newItem
        }
    }
}

