package com.aya.newsapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ArticlesModel (
    val source : SourceModel,
    var author : String? ,
    val title :String? ,
    val description : String?,
    val url : String?,
    val urlToImage : String?,
    var publishedAt:String? ,
    val content : String?
)