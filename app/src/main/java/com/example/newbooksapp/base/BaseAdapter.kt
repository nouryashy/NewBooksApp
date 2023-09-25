package com.example.newbooksapp.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BaseAdapter<T, VB : ViewBinding>(
    private val layoutInflater: LayoutInflater,
    private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    private val bindFunction: (VB, T) -> Unit,
) : RecyclerView.Adapter<BaseAdapter<T, VB>.ViewHolder>() {
    private var itemClickListener: ((T) -> Unit)? = null
    private var items = mutableListOf<T>()
    fun setOnItemClickListener(listener: (T) -> Unit) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = bindingInflater(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    fun setItems(newItems: List<T>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun filter(filterList: MutableList<T>) {
        items = filterList
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        bindFunction(holder.binding, item)
        holder.binding.root.setOnClickListener {
            itemClickListener?.invoke(item)
        }
    }

    inner class ViewHolder(val binding: VB) : RecyclerView.ViewHolder(binding.root)
}