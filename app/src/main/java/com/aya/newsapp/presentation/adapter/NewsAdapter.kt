package com.aya.newsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aya.newsapp.BR
import com.aya.newsapp.databinding.ItemNewsBinding
import com.aya.newsapp.domain.model.ArticlesModel
import com.aya.newsapp.presentation.interfaces.onClickDetails
import android.text.format.DateUtils
import com.aya.newsapp.utils.getTimeAgo
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class NewsAdapter(val onClick : onClickDetails)  :  ListAdapter<ArticlesModel, NewsAdapter.ViewHolder>(ArticlesModelDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = getItem(position)
        if(item.urlToImage != null) {

            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"))
            try {
                val time: Long = sdf.parse("2016-01-24T16:00:00.000Z").getTime()
                val now = System.currentTimeMillis()
                val ago = DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS)
                item.publishedAt = getTimeAgo(item.publishedAt) //ago.toString()
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            holder.bind(item)

        }
        holder.itemRowBinding.card.setOnClickListener {
            onClick.onClick(item)
        }
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