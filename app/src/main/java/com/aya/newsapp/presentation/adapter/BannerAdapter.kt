package com.aya.newsapp.presentation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.aya.newsapp.BR
import com.aya.newsapp.R
import com.aya.newsapp.databinding.ItemBannerBinding
import com.aya.newsapp.databinding.ItemNewsBinding
import com.aya.newsapp.domain.model.ArticlesModel
import com.aya.newsapp.domain.model.ArticlesTable
import com.aya.newsapp.presentation.interfaces.onClickDetails
import com.bumptech.glide.Glide
import com.example.moeidbannerlibrary.banner.BannerLayout

class BannerAdapter (val context: Context,
                    val onClickDetails: onClickDetails
                    ,private val urlList: ArrayList<ArticlesTable>) :
        RecyclerView.Adapter<BannerAdapter.subViewHolder?>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): subViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemBannerBinding.inflate(layoutInflater, parent, false)
            return  subViewHolder(binding)
        }

        override fun onBindViewHolder(holder: subViewHolder, position: Int) {
            val data = urlList[position]
            val item = urlList[position].urlToImage
         if(item != null && position <= 4) {
             holder.bind(data)
             Log.d("banner adapter",item)
            Glide.with(context).load(item).into(holder.itemRowBinding.image)

         }

            holder.itemRowBinding.bookMark.setOnClickListener {
                onClickDetails.onClickBookMarks(data)
            }
            holder.itemRowBinding.image.setOnClickListener {
                onClickDetails.onClick(data)
            }
        }

        override fun getItemCount(): Int =  5

    class subViewHolder(binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemRowBinding: ItemBannerBinding = binding
        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }
    }
    }
