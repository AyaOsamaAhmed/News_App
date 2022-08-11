package com.aya.newsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aya.newsapp.BR
import com.aya.newsapp.databinding.ItemNewsBinding
import com.aya.newsapp.domain.model.ArticlesModel

class NewsAdapter  :  ListAdapter<ArticlesModel, NewsAdapter.ViewHolder>(ArticlesModelDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = getItem(position)
            holder.bind(item)
    }

    class ArticlesModelDiffCallback :
        DiffUtil.ItemCallback<ArticlesModel>() {
        override fun areItemsTheSame(oldItem: ArticlesModel, newItem: ArticlesModel): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: ArticlesModel, newItem: ArticlesModel): Boolean {
                return oldItem == newItem
        }
    }

    class ViewHolder(binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemRowBinding: ItemNewsBinding = binding
        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }
    }
}