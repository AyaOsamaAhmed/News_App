package com.aya.newsapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.aya.newsapp.R
import com.bumptech.glide.Glide
import com.example.moeidbannerlibrary.banner.BannerLayout

class BannerAdapter (private val context: Context, private val urlList: List<String>?) :
        RecyclerView.Adapter<BannerAdapter.subViewHolder?>() {
        private var onBannerItemClickListener: BannerLayout.OnBannerItemClickListener? = null

        fun setOnBannerItemClickListener(onBannerItemClickListener: BannerLayout.OnBannerItemClickListener?) {
            this.onBannerItemClickListener = onBannerItemClickListener
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): subViewHolder {
            return subViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.banner_list_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: subViewHolder, position: Int) {
            if (urlList == null || urlList.isEmpty()) return
            val P = position % urlList.size
            val url = urlList[P]
            val img = holder.imageView
            Glide.with(context).load(url).into(img)
            img.setOnClickListener {
                if (onBannerItemClickListener != null) {
                    onBannerItemClickListener!!.onItemClick(P)
                }
            }
        }

        override fun getItemCount(): Int =  urlList?.size ?: 0

        inner class subViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            var imageView: ImageView

            init {
                imageView = itemView.findViewById<View>(R.id.image) as ImageView
            }
        }
    }
