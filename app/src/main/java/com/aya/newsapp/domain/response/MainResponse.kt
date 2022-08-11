package com.aya.newsapp.domain.response

import com.aya.newsapp.domain.model.ArticlesModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainResponse (

    @SerialName("status")
    val status: String ,
    @SerialName("totalResults")
    val totalResults: Int ,
    @SerialName("articles")
    val articles: ArrayList<ArticlesModel>



)
